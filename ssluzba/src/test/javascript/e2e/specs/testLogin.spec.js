var Login = require('../page_objects/login.page.js');
var GornjiMenu = require('../page_objects/gornjiMenu.page.js');

describe('Login page:', function() {
    var login;
    var gornjiMenu;

    beforeAll(function() {
        browser.navigate().to("http://park.ftn.uns.ac.rs:8080/#/");
        login = new Login();
        gornjiMenu = new GornjiMenu();
        expect(browser.getCurrentUrl()).toEqual('http://park.ftn.uns.ac.rs:8080/#/login');
    });

    it('should successfully log in as "ivanvojnovic"', function() {
        //čekanje da se pojavi log-in stranica
        browser.wait(function() {
            return browser.getCurrentUrl().then(function(url) {
                return url === 'http://park.ftn.uns.ac.rs:8080/#/login';
            });
        }, 5000, 'Login stranica ne može da se učita');

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

        // provera da li javlja grešku kad se unesu pogrešan username ili password
        login.username = "i";
        login.password = "i";
        login.prijaviSeBtn.click();

        var expectedMessage = "Pogrešno korisničko ime ili lozinka!";
        
        expect(login.loginProblem).toEqual(expectedMessage);

        // logovanje sa ispravnim username-om i password-om
        login.username.clear();
        login.password.clear();

        login.username = "ivanvojnovic7@gmail.com";
        login.password = "JQnnUEf9Ai5XycFMnKjK";
        login.prijaviSeBtn.click();
         
     });

     it('Promena jezika i logout."', function() {
         browser.wait(function() {
            return browser.getCurrentUrl().then(function(url) {
              return url === 'http://park.ftn.uns.ac.rs:8080/#/admin-institution/';
            });
          }, 5000, 'Could not navigate to admin');

        //promena jezika
        gornjiMenu.jezik.click();
        gornjiMenu.srpskiCir.click();

        gornjiMenu.jezik.click();
        gornjiMenu.srpskiLat.click();

        //odjava
        gornjiMenu.grb.click();
        gornjiMenu.odjava.click();
     });
});