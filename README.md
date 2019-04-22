# API GUS: wyszukiwarka REGON

Frontend: Angular 7, TypeScript, HTML, SCSS.  
Backend: Spring (REST API), Java.  
Zewnętrze API: API GUS (https://api.stat.gov.pl/)

## Opis
Aplikacja powstała w celu prezentacji wyników odebranych z API GUS.

Frontend aplikacji jest zaimplementowany przy użyciu framework'a Angular 7. Posiada prosty widok wyszukiwarki.

Backend aplikacji jest swego rodzaju adapterem pomiędzy warstwą Frontend, a zewnętrznym API. Opiera się o architekturę REST, natomiast dane z zewnętrzego API GUS pobierane są przy użyciu wygenerowanego klienta. Po otrzymaniu wyniku, dane są przerabiane i zwracane w postaci pliku JSON. Gdy firma nie zostanie znaleziona, zostaje zwracany błąd ze statusem 404, który jest obsługiwany po stronie frontend'u.

## Build

Aby uruchomić projekt lokalnie, potrzebujesz zainstalować takie technologie jak:
- Java (używana wersja: 8, Spring Boot: 2.1.4)
- Angular (używana werjsa: 7)
- Node.js (używana wersja: 10.15.1)

### Backend
1. Go to `gus-backend` folder.
2. Run the spring project (https://docs.spring.io/spring-boot/docs/current/reference/html/using-boot-running-your-application.html).

The app should be running on `localhost:8080`.

### Frontend
1. Go to `gus-frontend` folder.
2. Open command line and run: `npm install`.
3. Run command `ng serve`

Now the application should be available on the `localhost:4200` (run it in the web browser).


## Demo
![Demo gif](https://github.com/pawelidziak/api-gus-app/blob/master/appDemo.gif)
