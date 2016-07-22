var LoginPage = function() {};

LoginPage.prototype = Object.create({}, {


    loginText: {
        get: function() {
            return element(by.className("login-logo")).getText();
        }
    },

    username: {
        get: function() {
            return element(by.id('username'));
        },
        set: function(value) {
         this.username.clear();
         this.username.sendKeys(value);
        }
    },

    password: {
        get: function() {
            return element(by.id('password'));
        },
        set: function(value) {
         this.password.clear();
         this.password.sendKeys(value);
        }
    },

    odustaniBtn: {
        get: function() {
            return element(by.buttonText('Odustani'));
        }
    },

    prijaviSeBtn: {
        get: function() {
            return element(by.partialButtonText('Prijavi'));
        }
    },

    loginProblem: {
        get: function() {
            return element(by.repeater('error in errors track by $index')).getText();
        }
    },

    zaboravljenaLozinkaBtn: {
        get: function() {
            return element(by.buttonText('Zaboravili ste lozinku?'));
        }
    },


    unosCelogLogina: {
     value: function(usernameString, passwordString) {
            this.username = usernameString;
            this.password = passwordString;
            this.prijaviSeBtn.click();
        }
}
//------------------------------------------------------------
});

module.exports = LoginPage;