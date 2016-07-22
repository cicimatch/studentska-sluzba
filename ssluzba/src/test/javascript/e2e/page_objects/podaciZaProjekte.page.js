var PodaciZaProjektePage = function() {}

PodaciZaProjektePage.prototype = Object.create({}, {


    celaForma: {
        get: function() {
            return element(by.xpath("//form[@name='Project']"));
        }
    },


    brojRacuna: {
        get: function() {
            return element(by.model("data.account"));
        },
        set: function(value) {
            this.brojRacuna.clear();
            this.brojRacuna.sendKeys(value);
        }
    },

    brojRacunaError: {
        get: function() {
            return element(by.xpath("//div[@title=\"Broj računa *\"]//span[1]"));
        }
    },

    brojRacunaFormatError: {
        get: function() {
            return element(by.xpath("//div[@title=\"Broj računa *\"]//span[2]"));
        }
    },

    idBrojUInostranstvu: {
        get: function() {
            return element(by.model("data.mntrID"));
        },
        set: function(value) {
            this.idBrojUInostranstvu.clear();
            this.idBrojUInostranstvu.sendKeys(value);
        }
    },

    idMedjunarodniNivo: {
        get: function() {
            return element(by.model("data.orcid"));
        },
        set: function(value) {
            this.idMedjunarodniNivo.clear();
            this.idMedjunarodniNivo.sendKeys(value);
        }
    },

    statusInstitucije: {
        get: function() {
            return element(by.model("data.institutionStatus"));
        },
        set: function(value) {
            // this.statusInstitucije.clear();
            this.statusInstitucije.sendKeys(value);
        }
    },

    statusInstitucijeError: {
        get: function() {
            return element(by.xpath("//div[@title=\"Status institucije *\"]//span"));
        }
    },

    oblastIstrazivanja: {
        get: function() {
            return element(by.xpath("//div[@title='Oblast istraživanja']/div/div/div/ul/li"));
        },
        set: function(value) {
            this.oblastIstrazivanja.clear();
            this.oblastIstrazivanja.sendKeys(value);
        }
    },
    
    odustaniBtn: {
        get: function() {
            return element(by.xpath("//button[@ng-click='reset(Project)']"));
        }
    },

    sacuvajBtn: {
        get: function() {
            return element(by.xpath("//button[@ng-click='addctrl.saveInstitution(Project)']"));
        }
    }
});

module.exports = PodaciZaProjektePage;