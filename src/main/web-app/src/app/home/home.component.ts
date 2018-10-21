import { Component, OnInit } from '@angular/core';
import { Car } from './shared/cars.model';
import { MatchingService } from './shared/matching.service';
import { MatchingResults } from './shared/matching-results.model';
import { MessageService } from 'primeng/api';
import { HttpErrorResponse } from '@angular/common/http';
@Component({
    selector: 'app-home',
    templateUrl: './home.component.html',
    styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
    showTable: boolean = false;
    matchingResults: MatchingResults[] = [];
    cols: any[] = [];
    selectedResults: MatchingResults[] = [];
    constructor(private matchingService: MatchingService, private messageService: MessageService) { }

    actionUpload($event): void {
        let file: File[] = $event.files;
        const formData = new FormData();
        formData.append('file', file[0], file[0].name);
        this.messageService.clear();
        this.matchingService.getMatchingResults(formData).subscribe(
            results => {
                this.matchingResults = results;
                this.showTable = true;
            },
            (error: HttpErrorResponse) => {
                this.messageService.add({ severity: 'error', summary: error.statusText, detail: error.message });
                console.error(error);
            }
        );
    }
    getRowStyling(rowData: MatchingResults, column: any) {
        // console.log('Rowdata from styling = ' + JSON.stringify(rowData));
        if (column.field === 'matchingScore') {
            if (rowData.matchingScore === 100) {
                return 'full-matching';
            } else if (rowData.matchingScore < 100 && rowData.matchingScore > 80) {
                return 'good-matching';
            } else if (rowData.matchingScore < 80 && rowData.matchingScore > 70) {
                return 'average-matching';
            } else {
                return 'bad-matching';
            }
        }
    }

    private initColumnDefinitions(): void {
        this.cols = [
            { field: 'fissAddress', header: 'FISS Address' },
            { field: 'sdsAddress', header: 'SDS Address' },
            { field: 'matchingScore', header: 'Matching Score' },
        ];
    }
    ngOnInit() {
        this.initColumnDefinitions();
    }

}
