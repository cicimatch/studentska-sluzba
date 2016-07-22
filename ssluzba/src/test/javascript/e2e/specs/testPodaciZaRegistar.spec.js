var Login = require('../page_objects/login.page.js');
var OsnovniPodaci = require('../page_objects/osnovniPodaci.page.js');
var GornjiMenu = require('../page_objects/gornjiMenu.page.js');
var PodaciZaRegistar = require('../page_objects/podaciZaRegistar.page.js');


describe('Login page:', function() {
	var login;
    var osnovniPodaci;
    var gornjiMenu;
    var podaciZaRegistar;

    beforeAll(function() {
	    browser.navigate().to("http://park.ftn.uns.ac.rs:8080/#/login");
	    login = new Login();
	    osnovniPodaci = new OsnovniPodaci();
	    gornjiMenu = new GornjiMenu();
	    podaciZaRegistar = new PodaciZaRegistar();
	   
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

	it('Registar.', function() {
	   gornjiMenu.podaciZaRegistar.click();

       expect(podaciZaRegistar.poreskiID.isPresent()).toBe(true);
       expect(podaciZaRegistar.poreskiID.isDisplayed()).toBe(true);
       expect(podaciZaRegistar.maticniBroj.isPresent()).toBe(true);
       expect(podaciZaRegistar.maticniBroj.isDisplayed()).toBe(true);
       expect(podaciZaRegistar.brPoslednjeNaucneAkred.isPresent()).toBe(true);
       expect(podaciZaRegistar.brPoslednjeNaucneAkred.isDisplayed()).toBe(true);
       expect(podaciZaRegistar.datumPoslednjeNaucneAkred.isPresent()).toBe(true);
       expect(podaciZaRegistar.datumPoslednjeNaucneAkred.isDisplayed()).toBe(true);
       expect(podaciZaRegistar.nazivInstitucijeIzAkred.isPresent()).toBe(true);
       expect(podaciZaRegistar.nazivInstitucijeIzAkred.isDisplayed()).toBe(true);
       expect(podaciZaRegistar.napomenaORegistru.isPresent()).toBe(true);
       expect(podaciZaRegistar.napomenaORegistru.isDisplayed()).toBe(true);
       expect(podaciZaRegistar.vrstaInstitucije.isPresent()).toBe(true);
       expect(podaciZaRegistar.vrstaInstitucije.isDisplayed()).toBe(true);
       expect(podaciZaRegistar.osnovnaDelatnostInstitucije.isPresent()).toBe(true);
       expect(podaciZaRegistar.osnovnaDelatnostInstitucije.isDisplayed()).toBe(true);
       expect(podaciZaRegistar.osnivac.isPresent()).toBe(true);
       expect(podaciZaRegistar.osnivac.isDisplayed()).toBe(true);
       expect(podaciZaRegistar.datumOsnivanja.isPresent()).toBe(true);
       expect(podaciZaRegistar.datumOsnivanja.isDisplayed()).toBe(true);
       expect(podaciZaRegistar.brojResenjaOOsnvanju.isPresent()).toBe(true);
       expect(podaciZaRegistar.brojResenjaOOsnvanju.isDisplayed()).toBe(true);
       expect(podaciZaRegistar.vlasnickaStruktura.isPresent()).toBe(true);
       expect(podaciZaRegistar.vlasnickaStruktura.isDisplayed()).toBe(true);
      
       //provera kada su sva polja prazna (da li prikazuje greške)
       podaciZaRegistar.sacuvajBtn.click();
       expect(podaciZaRegistar.poreskiIDError.isDisplayed()).toBe(true);
       expect(podaciZaRegistar.maticniBrojError.isDisplayed()).toBe(true);
       expect(podaciZaRegistar.brPoslednjeNaucneAkredError.isDisplayed()).toBe(true);
       expect(podaciZaRegistar.datumPoslednjeNaucneAkredError.isDisplayed()).toBe(true);
       expect(podaciZaRegistar.nazivInstitucijeIzAkredError.isDisplayed()).toBe(true);
       expect(podaciZaRegistar.vrstaInstitucijeError.isDisplayed()).toBe(true);
       expect(podaciZaRegistar.vlasnickaStrukturaError.isDisplayed()).toBe(true);

       // provera da li prikazuje greške kada su pogresni unosi
       podaciZaRegistar.poreskiID = "blAa";
       podaciZaRegistar.maticniBroj = "blAa";

       expect(podaciZaRegistar.maticniBrojFormatError.isDisplayed()).toBe(true);
       expect(podaciZaRegistar.poreskiIDFormatError.isDisplayed()).toBe(true);

       // ispravan unos podataka
       podaciZaRegistar.poreskiID = "12345";
       podaciZaRegistar.maticniBroj = "1234567890123";
       podaciZaRegistar.brPoslednjeNaucneAkred = "23";
       podaciZaRegistar.datumPoslednjeNaucneAkred = "11.11.2011";
       podaciZaRegistar.nazivInstitucijeIzAkred = "Institucija Black";
       podaciZaRegistar.napomenaORegistru = "Napomene crno na belo";
       podaciZaRegistar.osnivac = "Ivan Vojnovic";
       podaciZaRegistar.brojResenjaOOsnvanju = "456783";
       podaciZaRegistar.vlasnickaStruktura = "Privatna";

       podaciZaRegistar.sacuvajBtn.click();

       // ove greške se prikazuju, jer ništa ne mogu da selektujem 
       expect(podaciZaRegistar.vrstaInstitucijeError.isDisplayed()).toBe(true);
        
       // greške se ne prikazuju
       expect(podaciZaRegistar.poreskiIDError.isDisplayed()).toBe(false);
       expect(podaciZaRegistar.maticniBrojError.isDisplayed()).toBe(false);
       expect(podaciZaRegistar.brPoslednjeNaucneAkredError.isDisplayed()).toBe(false);
       expect(podaciZaRegistar.datumPoslednjeNaucneAkredError.isDisplayed()).toBe(false);
       expect(podaciZaRegistar.nazivInstitucijeIzAkredError.isDisplayed()).toBe(false);
       expect(podaciZaRegistar.vlasnickaStrukturaError.isDisplayed()).toBe(false);
       expect(podaciZaRegistar.vlasnickaStrukturaError.isDisplayed()).toBe(false);  
       
  });
});