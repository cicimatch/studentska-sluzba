var IstrazivaciRegistarPage = function() {}

IstrazivaciRegistarPage.prototype = Object.create({}, {


    bibilografija: {
        get: function() {
            return element(by.model("data.bibliography"));
        },
        set: function(value) {
            this.bibilografija.clear();
            this.bibilografija.sendKeys(value);
        }
    },

    oblastIstrazivanja: {
        get: function() {
            return element(by.model("data.researchAreas"));
        },
        set: function(value) {
            this.oblastIstrazivanja.clear();
            this.oblastIstrazivanja.sendKeys(value);
        }
    },

    idMinistarstvo: {
        get: function() {
            return element(by.model("data.mntrn"));
        },
        set: function(value) {
            this.idMinistarstvo.clear();
            this.idMinistarstvo.sendKeys(value);
        }
    },

    napomena: {
        get: function() {
            return element(by.model("data.note"));
        },
        set: function(value) {
            this.napomena.clear();
            this.napomena.sendKeys(value);
        }
    },

    // Errors buttons
    bibiliografijaError: {
        get : function() {
            return element(by.xpath("//div[@title=\"Bibliografija *\"]//span"));
        }
    },

    oblastIstrazivanjaError: {
        get : function() {
            return element(by.xpath("//div[@title=\"Oblasti istraživanja *\"]//span"));
        }
    },

    idMinistarstvoError: {
        get : function() {
            return element(by.xpath("//div[@title=\"Identifikacioni broj u ministarstvu *\"]//span"));
        }
    },

    // Buttons
    odustaniBtn: {
        get: function() {
            return element(by.xpath("//button [@ng-click='reset()']"));
        }
    },

    sacuvajBtn: {
        get: function() {
            return element(by.xpath("//button [@ng-click='addctrl.savePerson(Register)']"));
        }
    }


});

module.exports = IstrazivaciRegistarPage;



