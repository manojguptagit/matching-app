import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { MatchingResults } from './matching-results.model';

@Injectable({
  providedIn: 'root'
})
export class MatchingService {

  constructor(private http: HttpClient) { }

  public getMatchingResults(formData: FormData): Observable<MatchingResults[]> {
    let url = 'http://localhost:8080/api/matching';
    return this.http.post<MatchingResults[]>(url, formData);
  }
}
