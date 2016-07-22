var CreateIstrazivaciPage = function() {}

CreateIstrazivaciPage.prototype = Object.create({}, {


    //gornji tabovi

     licniPodaci: {
        get: function() {
            return element(by.xpath("//a/tab-heading[text()='Lični podaci']/.."));
        }
    },

    podaciRegistar: {
        get: function() {
            return element(by.xpath("//a/tab-heading[text()='Podaci za registar']/.."));
        }
    },

    podaciZaProjekte: {
        get: function() {
            return element(by.xpath("//a/tab-heading[text()='Podaci za projekte']/.."));
        }
    },

    // -------------
    ime: {
        get: function() {
            return element(by.model("data.firstName"));
        },
        set: function(value) {
            this.ime.clear();
            this.ime.sendKeys(value);
        }
    },

    imeError: {
        get : function() {
            return element(by.xpath("//div[@title=\"Ime *\"]//span"));
        }
    },

    prezime: {
        get: function() {
            return element(by.model('value'));
        },
        set: function(value) {
         this.prezime.clear();
         this.prezime.sendKeys(value);
        }
    },


    prezimeError:{
        get: function() {
            return element(by.xpath("//form[@name='typeaheadForm']//span"));
        }
    },

    imeRoditelja: {
        get: function() {
            return element(by.model("data.middleName"));
        },
        set: function(value) {
            this.imeRoditelja.clear();
            this.imeRoditelja.sendKeys(value);
        }
    },

    titulaIstrazivaca: {
        get: function() {
            return element(by.model("data.title"));
        },
        set: function(value) {
            this.titulaIstrazivaca.sendKeys(value);
        }
    },

    // prepravicu ovo
    datumRodjenja: {
        get: function() {
            return element(by.xpath("//input[@placeholder='dd.MM.yyyy']"));
        },
        set: function(value) {
            this.datumRodjenja.clear();
            this.datumRodjenja.sendKeys(value);
        }
    },

    drzavaRodjenja: {
        get: function() {
            return element(by.model("data.state"));
        },
        set: function(value) {
            this.drzavaRodjenja.clear();
            this.drzavaRodjenja.sendKeys(value);
        }
    },
    
    mestoRodjenja: {
        get: function() {
            return element(by.model("data.placeOfBirth"));
        },
        set: function(value) {
            this.mestoRodjenja.clear();
            this.mestoRodjenja.sendKeys(value);
        }
    },

    opstinaRodjenja: {
        get: function() {
            return element(by.model("data.townShipOfBirth"));
        },
        set: function(value) {
            this.opstinaRodjenja.clear();
            this.opstinaRodjenja.sendKeys(value);
        }
    },

    drzavaBoravista: {
        get: function() {
            return element(by.model("data.stateOfResidence"));
        },
        set: function(value) {
            this.drzavaBoravista.clear();
            this.drzavaBoravista.sendKeys(value);
        }
    },

    mestoBoravista: {
        get: function() {
            return element(by.model("data.city"));
        },
        set: function(value) {
            this.mestoBoravista.clear();
            this.mestoBoravista.sendKeys(value);
        }
    },

    opstinaBoravista: {
        get: function() {
            return element(by.model("data.townShipOfResidence"));
        },
        set: function(value) {
            this.opstinaBoravista.clear();
            this.opstinaBoravista.sendKeys(value);
        }
    },

    ulicaIBrojBoravista: {
        get: function() {
            return element(by.model("data.address"));
        },
        set: function(value) {
            this.ulicaIBrojBoravista.clear();
            this.ulicaIBrojBoravista.sendKeys(value);
        }
    },


    pol: {
        get: function() {
            return element(by.model("data.gender"));
        },
        set: function(value) {
            // this.pol.clear();
            this.pol.sendKeys(value);
        }
    },

    izabraniPol:{
        get: function() {
            return element(by.css("select[name=gender] option:checked"));
        }
    },

    jmbg: {
        get: function() {
            return element(by.model("data.jmbg"));
        },
        set: function(value) {
            this.jmbg.clear();
            this.jmbg.sendKeys(value);
        }
    },

    jmbgError: {
        get : function() {
            return element(by.xpath("//div[@title=\"JMBG / Broj pasoša *\"]//span[1]"));
        }
    },

    jmbgFormatError: {
        get : function() {
            return element(by.xpath("//div[@title=\"JMBG / Broj pasoša *\"]//span[2]"));
        }
    },

    elektronskaPosta: {
        get: function() {
            return element(by.model("data.email"));
        },
        set: function(value) {
            this.elektronskaPosta.clear();
            this.elektronskaPosta.sendKeys(value);
        }
    },

    telefon: {
        get: function() {
            return element(by.model("data.phones"));
        },
        set: function(value) {
            this.telefon.clear();
            this.telefon.sendKeys(value);
        }
    },

    licnaVebAdresa: {
        get: function() {
            return element(by.model("data.uri"));
        },
        set: function(value) {
            this.licnaVebAdresa.clear();
            this.licnaVebAdresa.sendKeys(value);
        }
    },

    statusIstrazivaca: {
        get: function() {
            return element(by.model("data.personStatus"));
        },
        set: function(value) {
            // this.statusIstrazivaca.clear();
            this.statusIstrazivaca.sendKeys(value);
        }
    },

    odustaniBtn: {
        get: function() {
            return element(by.xpath("//button [@ng-click='reset()']"));
        }
    },

    sacuvajBtn: {
        get: function() {
            return element(by.xpath("//button [@ng-click='addctrl.savePerson(Basic)']"));
        }
    },



    popuniCeluFormu:{
         value:function( ime,  prezime,  imeRod,  titula,  datum,  drzavaR,  mestoR,  opstinaR,  drzavaB,  mestoB,  opstinaB,  ulica, pol,  jmbg,  email,  tel,  Webadd,  status){

               this.ime = ime;
               this.prezime = prezime;
               this.imeRoditelja = imeRod;
               this.titulaIstrazivaca = titula;
               this.datumRodjenja = datum;
               this.drzavaRodjenja = drzavaR;
               this.mestoRodjenja = mestoR;
               this.opstinaRodjenja = opstinaR;
               this.drzavaBoravista = drzavaB;
               this.mestoBoravista = mestoB;
               this.opstinaBoravista = opstinaB;
               this.ulicaIBrojBoravista = ulica;
               this.pol = pol;
               this.jmbg = jmbg;
               this.elektronskaPosta = email;
               this.telefon = tel;
               this.licnaVebAdresa = Webadd;
               this.statusIstrazivaca = status;

         }
     }



});

module.exports = CreateIstrazivaciPage;
