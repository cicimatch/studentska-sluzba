var Login = require('../page_objects/login.page.js');
var GornjiMenu = require('../page_objects/gornjiMenu.page.js');
var Istrazivaci = require('../page_objects/istrazivaci.page.js');
var CreateIstrazivaci = require('../page_objects/createIstrazivaci.page.js');
var Angazuj = require('../page_objects/angazuj.page.js');
var SuccesModal = require('../page_objects/succesModal.page.js');

describe('Login page:', function() {
	var login;
	var gornjiMenu;
	var istrazivaci;
	var createIstrazivaci;
	var angazuj;
	var succesModal;

  	beforeAll(function() {
  		browser.navigate().to("http://park.ftn.uns.ac.rs:8080/#/login");
  		login = new Login();
  		gornjiMenu = new GornjiMenu();
  		istrazivaci = new Istrazivaci();
  		createIstrazivaci = new CreateIstrazivaci();
  		angazuj = new Angazuj();
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
  	     
	it('angazuj', function() {
  		browser.wait(function() {
  			  return gornjiMenu.istrazivaciTab.click()
  		}, 5000, 'Could not navigate to istrazivaci');
  		  
  		angazuj.modal.click();
  	    
  	     /* provera a li je dugme tu
         expect(gornjiMenu.istrazivaciBtn.isPresent()).toBe(true);
         expect(gornjiMenu.istrazivaciBtn.isDisplayed()).toBe(true);
         expect(gornjiMenu.istrazivaciBtn.isEnabled()).toBe(true);

         gornjiMenu.istrazivaciBtn.click();

         istrazivaci.istrazivacRowByIme("Mika Mikic").click();*/
  		  
  		  // ne znam
  	});
});