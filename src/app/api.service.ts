import {Injectable} from '@angular/core'
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {AttributeMarker} from '@angular/compiler';

export interface User{
  id?: number;
  email:string;
  firstName:string;
  lastName:string;
  nationalCode:string;
}

export interface Book{
  id?:number;
  title:string;
  publisher:string;
  available:boolean;
  borrowedBy: User;
}

@Injectable({providedIn : 'root'})
export class ApiService{
  private baseUrl= 'http://localhost:8080';

  constructor(private http: HttpClient) {}

    getAllUser(): Observable<User[]>{
      return this.http.get<User[]>(`${this.baseUrl}/user`);
    }

    getUserById(id : number) :Observable<User>{
    return this.http.get<User>(`${this.baseUrl}/user/${id}`);
    }


    saveUser(user : User) : Observableb<User>{
    return this.http.post<User>(`${this.baseUrl}/user`,user);
    }

    editUser(user : User) : Observable<User>{
    return this.http.put<User>(`${this.baseUrl}/user` , user);
    }

    deleteUser(id :number) : Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/user/${id}`);
    }


    getAllBooks():Observable<Book[]>{
    return this.http.get<Book[]>(`${this.baseUrl}/book`);
    }

    getBookById(id : number) : Observable<Book>{
    return this.http.get<Book>(`${this.baseUrl}/book/${id}`)
    }

    saveBook(book : Book): Observable<Book>{
    return this.http.post<Book>(`${this.baseUrl}/book` , book);
    }

    editBook(book : Book) : Observable<Book>{
    return this.http.put<Book>(`${this.baseUrl}/book/` , book);
    }

    deleteBook(id : number) : Observable<void>{
    return this.http.delete<void>(`${this.baseUrl}/book/${id}`)
    }

    borrowBook(bookId : number , userId: number): Observable<Book>{
    return this.http.put<Book>(`${this.baseUrl}/book/${bookId}/borrow/${userId}` , {})
    }
}

