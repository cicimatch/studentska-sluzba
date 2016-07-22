var angazujPage = function() {};


angazujPage.prototype = Object.create({}, {


    naslov:{
        get: function() {
            return element(by.xpath("//span[text() = 'Angažuj']"));
        }
    },
    
    modal: {
    	get: function() {
    		return element(by.xpath("//button[@ng-click='addctrl.addConnection()']"));
    	}
    },


    zvanje: {
        get: function() {
            return element(by.model('connection.position'));
        },
        set: function(value) {

         this.zvanje.sendKeys(value);
        }
    },


    funkcija: {
        get: function() {
            return element(by.model('connection.function'));
        },
        set: function(value) {

         this.funkcija.sendKeys(value);
        }
    },

    datumOd: {
        get: function() {
            return element(by.xpath("//em-date-time-picker[@name='startDate']//input"));
        },
        set: function(value) {

         this.datumOd.sendKeys(value);
        }
    },

    datumOdError:{
        get: function() {
            return element(by.xpath("//span[text()='Unesite datum angažovanja.']"));
        }
    },

    datumDo: {
        get: function() {
            return element(by.xpath("//em-date-time-picker[@name='endDate']//input"));
        },
        set: function(value) {

         this.datumDo.sendKeys(value);
        }
    },

    // Buttons
    angazujBtn:{
        get: function() {
            return element(by.xpath("//div[@class='modal-footer ng-scope']//button[@name='btnSave']"));
        }
    },

    odustaniBtn:{
        get: function() {
            return element(by.xpath("//div[@class='modal-footer ng-scope']//button[@class='btn btn-lg btn-brown ng-binding']"));
        }
    }



});


module.exports = angazujPage;