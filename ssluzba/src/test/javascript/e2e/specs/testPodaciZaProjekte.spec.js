var Login = require('../page_objects/login.page.js');
var GornjiMenu = require('../page_objects/gornjiMenu.page.js');
var PodaciZaProjekte = require('../page_objects/podaciZaProjekte.page.js');
var SuccesModal = require('../page_objects/succesModal.page.js');

describe('Login page:', function() {
  var login;
  var gornjiMenu;
  var podaciZaProjekte;
  var succesModal;

  beforeAll(function() {
    browser.navigate().to("http://park.ftn.uns.ac.rs:8080/#/login");
    login = new Login();
    gornjiMenu = new GornjiMenu();
    podaciZaProjekte = new PodaciZaProjekte();
    succesModal = new SuccesModal();

   expect(browser.getCurrentUrl()).toEqual('http://park.ftn.uns.ac.rs:8080/#/login');
  });

  it('should successfully log in as "ivanvojnovic"', function() {
    browser.wait(function() {
      return browser.getCurrentUrl().then(function(url) {
        return url === 'http://park.ftn.uns.ac.rs:8080/#/login';
      });
    }, 5000, 'Could not navigate to login');
    
    // provera da se "prijaviSeBtn" ne moze pritisnuti pre nekog unosa
    expect(login.prijaviSeBtn.isEnabled()).toBe(false);

    expect(login.username.isPresent()).toBe(true);
    expect(login.username.isDisplayed()).toBe(true);
    expect(login.password.isPresent()).toBe(true);
    expect(login.password.isDisplayed()).toBe(true);
    expect(login.odustaniBtn.isPresent()).toBe(true);
    expect(login.odustaniBtn.isDisplayed()).toBe(true);
    expect(login.prijaviSeBtn.isPresent()).toBe(true);
    expect(login.prijaviSeBtn.isDisplayed()).toBe(true);

    login.username = "ivanvojnovic7@gmail.com";
    login.password = "JQnnUEf9Ai5XycFMnKjK";
    login.prijaviSeBtn.click();

     browser.wait(function() {
      return browser.getCurrentUrl().then(function(url) {
        return url === 'http://park.ftn.uns.ac.rs:8080/#/admin-institution/';
      });
    }, 5000, 'Could not navigate to login');
  });

   it('projekti.', function() {
	   gornjiMenu.podaciZaProjekte.click();

	   // provera da li su sva polja prikazana
       expect(podaciZaProjekte.brojRacuna.isPresent()).toBe(true);
       expect(podaciZaProjekte.brojRacuna.isDisplayed()).toBe(true);
       expect(podaciZaProjekte.idBrojUInostranstvu.isPresent()).toBe(true);
       expect(podaciZaProjekte.idBrojUInostranstvu.isDisplayed()).toBe(true);
       expect(podaciZaProjekte.idMedjunarodniNivo.isPresent()).toBe(true);
       expect(podaciZaProjekte.idMedjunarodniNivo.isDisplayed()).toBe(true);
       expect(podaciZaProjekte.statusInstitucije.isPresent()).toBe(true);
       expect(podaciZaProjekte.statusInstitucije.isDisplayed()).toBe(true);
       expect(podaciZaProjekte.oblastIstrazivanja.isPresent()).toBe(true);
       expect(podaciZaProjekte.oblastIstrazivanja.isDisplayed()).toBe(true);
       expect(podaciZaProjekte.odustaniBtn.isPresent()).toBe(true);
       expect(podaciZaProjekte.odustaniBtn.isDisplayed()).toBe(true);
       expect(podaciZaProjekte.sacuvajBtn.isPresent()).toBe(true);
       expect(podaciZaProjekte.sacuvajBtn.isDisplayed()).toBe(true);
        
        // provera da li javlja greske za prazna polja
        podaciZaProjekte.brojRacuna.clear();
        podaciZaProjekte.idMedjunarodniNivo.clear();
        podaciZaProjekte.idMedjunarodniNivo.clear();
        podaciZaProjekte.sacuvajBtn.click();
        expect(podaciZaProjekte.brojRacunaError.isDisplayed()).toBe(true);
        // expect(podaciZaProjektePage.statusInstitucijeError.isDisplayed()).toBe(true);

        // provera da li javlja gresku o formatu broja računa
        podaciZaProjekte.brojRacuna = "dsds";
        expect(podaciZaProjekte.brojRacunaFormatError.isDisplayed()).toBe(true);

        // provera kada je format broja računa ispravana
        podaciZaProjekte.brojRacuna.clear();
        podaciZaProjekte.brojRacuna = "123-1234567890123-12";
        expect(podaciZaProjekte.brojRacunaError.isDisplayed()).toBe(false);
        expect(podaciZaProjekte.brojRacunaFormatError.isDisplayed()).toBe(false);
        
        podaciZaProjekte.idMedjunarodniNivo = "123";
        // Zaključano polje - test failuje
        podaciZaProjekte.statusInstitucije = "Status";
        podaciZaProjekte.sacuvajBtn.click();


	     // čekanje da se pojavi dijalog da su podaci sačuvani
	    browser.wait(function() {
	       return succesModal.succesModalAppears.isDisplayed();
	    }, 3000);
	    succesModal.succesModalAppears.click();
	
	    //Potvrda da se nakon klika na "Sačuvaj" otvara zeleni Modal "success"
	    expect(succesModal.succesModalAppears.isPresent()).toBe(true);
	    expect(succesModal.succesModalAppears.isDisplayed()).toBe(true);
	   
	    // i gasimo ga sa: "x" 
        succesModal.xBtn.click();

        // Sačekati da se modal skloni sa stranice
        browser.wait(function() {
          return succesModal.succesModalAppears.isPresent().then(function(isPresent) {
            return !isPresent;
          });
        }, 5000, 'Modal dialog never disappeared');

        expect(succesModal.succesModalAppears.isPresent()).toBe(false);

        gornjiMenu.grb.click();
        gornjiMenu.odjava.click();
   });
});