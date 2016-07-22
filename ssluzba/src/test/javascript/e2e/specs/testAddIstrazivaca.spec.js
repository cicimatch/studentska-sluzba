var Login = require('../page_objects/login.page.js');
var GornjiMenu = require('../page_objects/gornjiMenu.page.js');
var OsnovniPodaci = require('../page_objects/osnovniPodaci.page.js');
var SuccesModal = require('../page_objects/succesModal.page.js');
var PodaciZaRegistar = require('../page_objects/podaciZaRegistar.page.js');
var PodaciZaProjekte = require('../page_objects/podaciZaProjekte.page.js');
var Istrazivaci = require('../page_objects/istrazivaci.page.js');
var CreateIstrazivaci = require('../page_objects/createIstrazivaci.page.js');
var Angazuj = require('../page_objects/angazuj.page.js');


describe('test Istarzivaci', function() {
	var login;
	var gornjiMenu;
	var osnovniPodaci;
	var succesModal;
	var podaciZaRegistar;
	var podaciZaProjekte;
	var istrazivaci;
	var createIstrazivaci;
	var angazuj;

	beforeAll(function() {
	    browser.navigate().to("http://park.ftn.uns.ac.rs:8080/#/login");
	    login = new Login();
	    gornjiMenu = new GornjiMenu();
	    osnovniPodaci = new OsnovniPodaci();
	    succesModal = new SuccesModal();
	    podaciZaRegistar = new PodaciZaRegistar();
	    podaciZaProjekte = new PodaciZaProjekte();
	    istrazivaci = new Istrazivaci();
	    createIstrazivaci =new CreateIstrazivaci();
	    angazuj = new Angazuj();

	    // čekanje da se pojavi log-in stranica
	    browser.wait(function() {
	      return browser.getCurrentUrl().then(function(url) {
	        return url === 'http://park.ftn.uns.ac.rs:8080/#/login';
	      });
	    }, 5000, 'Login stranica ne može da se učita');
	
	    expect(browser.getCurrentUrl()).toEqual('http://park.ftn.uns.ac.rs:8080/#/login');
	
	    // unosimo pogrešne login i password odjednom - POGREŠNO
	    login.unosCelogLogina('david.beckam@yahoo.com', 'JQnnUEf9Ai5XycFMnKjK');
	
	    // pravimo varijabli sa textom očekivane poruke
	    var ocekivanaPoruka = "Pogrešno korisničko ime ili lozinka!";
	    // expectujemo je sa porukom koju smo očelivali ta očekivana porka o grešci
	    expect(login.loginProblem).toEqual(ocekivanaPoruka);
	
	    // unosim login i password u jednom potezu - ISPRAVNO i idemo dalje
	    login.unosCelogLogina("ivanvojnovic7@gmail.com", "JQnnUEf9Ai5XycFMnKjK");
	
	    // čekam da se pojavi glavna stranica
	    browser.wait(function() {
	      return browser.getCurrentUrl().then(function(url) {
	        return url === 'http://park.ftn.uns.ac.rs:8080/#/admin-institution/';
	      });
	    }, 5000, 'Nakon prijave ne uspeva da se prebaci na glavnu stranicu');
    });

    // test
    it('Dodavanje istrazivaca', function() {
        expect(gornjiMenu.istrazivaciBtn.isPresent()).toBe(true);
        expect(gornjiMenu.istrazivaciBtn.isDisplayed()).toBe(true);
        expect(gornjiMenu.istrazivaciBtn.isEnabled()).toBe(true);

        // klik na istraživači button
        gornjiMenu.istrazivaciBtn.click();

        browser.wait(function() {
          return browser.getCurrentUrl().then(function(url) {
	          return url === 'http://park.ftn.uns.ac.rs:8080/#/persons';
          });
        }, 5000, 'Istrazivaci stranica ne može da se učita');

        expect(istrazivaci.istrazivaciTable.isDisplayed()).toBe(true);
        expect(istrazivaci.dodajIstrazivacaBtn.isDisplayed()).toBe(true);

        istrazivaci.dodajIstrazivacaBtn.click();

        browser.wait(function() {
            return browser.getCurrentUrl().then(function(url) {
  	          return url === 'http://park.ftn.uns.ac.rs:8080/#/persons/';
            });
          }, 5000, 'Istrazivaci stranica ne može da se učita');
        
        // Proveravamo da li su svi polja OK
        expect(createIstrazivaci.licniPodaci.isPresent());
        expect(createIstrazivaci.licniPodaci.isDisplayed());
        expect(createIstrazivaci.licniPodaci.isEnabled());
        expect(createIstrazivaci.podaciRegistar.isPresent());
        expect(createIstrazivaci.podaciRegistar.isDisplayed());
        expect(createIstrazivaci.podaciRegistar.isEnabled());
        expect(createIstrazivaci.podaciZaProjekte.isPresent());
        expect(createIstrazivaci.podaciZaProjekte.isDisplayed());
        expect(createIstrazivaci.podaciZaProjekte.isEnabled()); 

        // provera grešaka
        createIstrazivaci.sacuvajBtn.click();
        expect(createIstrazivaci.imeError.isPresent()).toBe(true);
        expect(createIstrazivaci.imeError.isDisplayed()).toBe(true);
        expect(createIstrazivaci.prezimeError.isPresent()).toBe(true);
        expect(createIstrazivaci.prezimeError.isDisplayed()).toBe(false);

        // unos cele forme
        createIstrazivaci.popuniCeluFormu("Danijela 13_protractor", "Istraživač", "lela", "Mr", "01.01.1984", "Srbija", "NoviSad", 
        		"NoviSad", "Srbija", "Bor", "Bor", "NN123", "Ženski", "22019811111111111", "lela@gmail.com", "303", "www.nesto.com", "Saradnik");

        createIstrazivaci.sacuvajBtn.click();

        // čeka se SUCCESS modal
        browser.wait(function() {
          return succesModal.succesModalAppears.isDisplayed();
        }, 3000);
        succesModal.succesModalAppears.click();

        // Potvrda da se nakon klika na "Sačuvaj" otvara zeleni Modal "success"
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
