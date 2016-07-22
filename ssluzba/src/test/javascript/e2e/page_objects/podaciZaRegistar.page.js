var PodaciZaRegistarPage = function() {}

PodaciZaRegistarPage.prototype = Object.create({}, {

    /**
     * Za razliku od Jave gde sam sve pisao skraćenice, al'
     * svako polje komentarisao, ovde je jasno na šta se svako polje odnosi.
     * Gde su errors dugmad smeštena odmah posle funkcija.
     */

    celaForma: {
        get: function() {
            return element(by.xpath("//form[@name='Register']"));
        }
    },

    poreskiID: {
        get: function() {
            return element(by.model("data.pib"));
        },
        set: function(value) {
            this.poreskiID.clear();
            this.poreskiID.sendKeys(value);
        }
    },

    poreskiIDError: {
        get : function() {
            return element(by.xpath("//div[@title=\"Poreski identifikacioni broj *\"]//span[1]"));
        }
    },

    poreskiIDFormatError: {
        get : function() {
            return element(by.xpath("//div[@title=\"Poreski identifikacioni broj *\"]//span[2]"));
        }
    },

    maticniBroj: {
        get: function() {
            return element(by.model("data.maticniBroj"));
        },
        set: function(value) {
            this.maticniBroj.clear();
            this.maticniBroj.sendKeys(value);
        }
    },

    maticniBrojError: {
        get : function() {
            return element(by.xpath("//div[@title=\"Matični broj *\"]//span[1]"));
        }
    },

    maticniBrojFormatError: {
        get : function() {
            return element(by.xpath("//div[@title=\"Matični broj *\"]//span[2]"));
        }
    },

    brPoslednjeNaucneAkred: {
        get: function() {
            return element(by.model("data.accreditationNumber"));
        },
        set: function(value) {
            this.brPoslednjeNaucneAkred.clear();
            this.brPoslednjeNaucneAkred.sendKeys(value);
        }
    },

    brPoslednjeNaucneAkredError: {
        get : function() {
            return element(by.xpath("//div[@title=\"Broj poslednje naučne akreditacije *\"]//span"));
        }
    },

    datumPoslednjeNaucneAkred: {
        get: function() {
            return element(by.xpath("//em-date-time-picker[@name='accreditationDate']/span/div/input"));
        },
        set: function(value) {
            this.datumPoslednjeNaucneAkred.clear();
            this.datumPoslednjeNaucneAkred.sendKeys(value);
        }
    },

   datumPoslednjeNaucneAkredError: {
        get : function() {
            return element(by.xpath("//span[contains(text(), 'Unesite datum akreditacije!')]"));
        }
    },

    nazivInstitucijeIzAkred: {
        get: function() {
            return element(by.model("data.accreditationNote"));
        },
        set: function(value) {
            this.nazivInstitucijeIzAkred.clear();
            this.nazivInstitucijeIzAkred.sendKeys(value);
        }
    },

    nazivInstitucijeIzAkredError: {
        get : function() {
            return element(by.xpath("//div[@title=\"Naziv institucije iz akreditacije *\"]//span"));
        }
    },

     napomenaORegistru: {
        get: function() {
            return element(by.model("data.note"));
        },
        set: function(value) {
            this.napomenaORegistru.clear();
            this.napomenaORegistru.sendKeys(value);
        }
    },

     vrstaInstitucije: {
        get: function() {
            return element(by.model("data.type"));
        },
        set: function(value) {
            this.vrstaInstitucije.clear();
            this.vrstaInstitucije.sendKeys(value);
        }
    },

    vrstaInstitucijeError: {
        get : function() {
            return element(by.xpath("//div[@title=\"Vrsta institucije *\"]//span"));
        }
    },

     osnovnaDelatnostInstitucije: {
        get: function() {
            return element(by.xpath("//select[@name='ownershipStructure']"));
        },
        set: function(value) {
            // this.osnovnaDelatnostInstitucije.clear();
            // this.osnovnaDelatnostInstitucije.sendKeys(value);
        }
    },

    osnivac: {
        get: function() {
            return element(by.model("data.founder"));
        },
        set: function(value) {
            this.osnivac.clear();
            this.osnivac.sendKeys(value);
        }
    },


    datumOsnivanja: {
        get: function() {
            return element(by.xpath("//em-date-time-picker[@name='date']/span/div/input"));
        },
        set: function(value) {
            this.osnivac.clear();
            this.osnivac.sendKeys(value);
        }
    },

    brojResenjaOOsnvanju: {
        get: function() {
            return element(by.model("data.rescriptNumber"));
        },
        set: function(value) {
            this.brojResenjaOOsnvanju.clear();
            this.brojResenjaOOsnvanju.sendKeys(value);
        }
    },

    vlasnickaStruktura: {
        get: function() {
            return element(by.model("data.ownershipStructure"));
        },
        set: function(value) {
          
            this.vlasnickaStruktura.sendKeys(value);
        }
    },

    vlasnickaStrukturaError: {
        get : function() {
            return element(by.xpath("//div[@title=\"Vlasnička struktura *\"]//span"));
        }
    },

    // Buttons
    odustaniBtn: {
        get: function() {
            return element(by.xpath("//button[@ng-click='reset(Register)']"));
        }
    },

    sacuvajBtn: {
        get: function() {
            return element(by.xpath("//button[@ng-click='addctrl.saveInstitution(Register)']"));
        }
    }
    
});

module.exports = PodaciZaRegistarPage;