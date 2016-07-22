var OsnovniPodaciPage = function() {};

OsnovniPodaciPage.prototype = Object.create({}, {
	
	
	/**
     * Ona 3 taba iznad forme. U Javi sam ih smeštao u druge klase.
     * Ovde neka budu tu. 
     */
    osnovniPodaciTab: {
        get: function() {
            return element.all(by.xpath('//ul[@class="nav nav-tabs"]/li[1]'));
        }
    },

    podaciZaRegistarTab: {
        get: function() {
            return element.all(by.xpath('//ul[@class="nav nav-tabs"]/li[2]'));
        }
    },

    podaciZaProjekteTab: {
        get: function() {
            return element.all(by.xpath('//ul[@class="nav nav-tabs"]/li[3]'));
        }
    },


    // Forma
    celaForma: {
        get: function() {
            return element(by.xpath("//form[@name='Basic']"));
        }
    },

    // Institucija
    nazivInstitucije: {
        get: function() {
            return element(by.model('data.name'));
        },
        set: function(value) {
         this.nazinazivInstitucijev.clear();
         this.nazivInstitucije.sendKeys(value);
        }
    },

    // Institucija na Eng.
    nazivInstitucijeEng: {
        get: function() {
            return element(by.model('data.nameEn'));
        },
        set: function(value) {
         this.nazivInstitucijeEng.clear();
         this.nazivInstitucijeEng.sendKeys(value);
        }
    },

    //za drzavu malo drugačije. Po defaultu-u je tu "Srbija" ...
    drzava: {
        get: function() {
            return element(by.model('data.state'));
        },
        set: function(value) {
         this.drzava.sendKeys(value);
        }
    },

    /** 
     * U funkciju "drzava" treba da prosledimo vrednost "Dodaj novu ..."      
     * i onda se otvara opcija. DropDown button
     */
    novaDrzava: {
        get: function() {
            return element(by.model('addctrl.state.name'));
        },
        set: function(value) {
         this.novaDrzava.clear();
         this.novaDrzava.sendKeys(value);
        }
    },

    // Ime nove države, njen opis i confirm button
    opisNoveDrzave: {
        get: function() {
            return element(by.model('addctrl.state.description'));
        },
        set: function(value) {
         this.opisNoveDrzave.clear();
         this.opisNoveDrzave.sendKeys(value);
        }
    },

    tacnoBtn: {
        get: function() {
            return element(by.name('btnSave'));
        }
    },

    // Mesto (grad)
    mesto: {
        get: function() {
            return element(by.model('data.place'));
        },
        set: function(value) {
         this.mesto.clear();
         this.mesto.sendKeys(value);
        }
    },

    // Opština
    opstina: {
        get: function() {
            return element(by.model('data.townShipText'));
        },
        set: function(value) {
         this.opstina.clear();
         this.opstina.sendKeys(value);
        }
    },

    // Adresa
    ulicaIBroj: {
        get: function() {
            return element(by.model('data.address'));
        },
        set: function(value) {
         this.ulicaIBroj.clear();
         this.ulicaIBroj.sendKeys(value);
        }
    },

     webAdresa: {
        get: function() {
            return element(by.model('data.uri'));
        },
        set: function(value) {
         this.webAdresa.clear();
         this.webAdresa.sendKeys(value);
        }
    },

    elektronskaPosta: {
        get: function() {
            return element(by.model('data.email'));
        },
        set: function(value) {
         this.elektronskaPosta.clear();
         this.elektronskaPosta.sendKeys(value);
        }
    },

    telefon: {
        get: function() {
            return element(by.model('data.phone'));
        },
        set: function(value) {
         this.telefon.clear();
         this.telefon.sendKeys(value);
        }
    },

    skraceniNaziv: {
        get: function() {
            return element(by.model('data.acro'));
        },
        set: function(value) {
         this.skraceniNaziv.clear();
         this.skraceniNaziv.sendKeys(value);
        }
    },

    // DropDown za instituciju, koji je kao zaključan bio
    institucijaDDklik: {
        get: function() {
            return element(by.xpath("//a[@class='select2-choice']"));
        }
    },
    
    institucijaDropDown: {
        get: function() {
            return element(by.id("s2id_autogen2_search"));
     },
     set: function(value) {
        this.skraceniNaziv.clear();
        this.skraceniNaziv.sendKeys(value + '\n');
        }
    },

    //kad hoćemo da proverimo da li je selektovano. Za svaki Select novi selektor mora
    proveraSime: {
        get: function() {
            return element(by.xpath("//option[text()='Institucija Sima Simic']"));
        }
    },


    // Buttons
    sacuvajBtn: {
        get: function() {
            return element(by.partialButtonText('Sačuvaj'));
        }
    },

    odustaniBtn: {
        get: function() {
            return element(by.partialButtonText('Odustani'));
        }
    },

    //Error poruke o grešci
     nazivInstitucijeError: {
        get : function() {
            return element(by.xpath("//div[@title=\"Naziv institucije *\"]//span"));
        }
    },

    mestoError: {
        get : function() {
            return element(by.xpath("//span[contains(text(), 'Morate uneti mesto.')]"));
        }
    },

    ulicaError: {
        get : function() {
            return element(by.xpath("//div[@title=\"Ulica i broj *\"]//span"));
        }
    },

    webError: {
        get : function() {
            return element(by.xpath("//div[@title=\"Veb adresa *\"]//span"));
        }
    },

    emailError: {
        get : function() {
            return element(by.xpath("//div[@title=\"Elektronska pošta *\"]//span"));
        }
    },

    telefonError: {
        get : function() {
            return element(by.xpath("//div[@title=\"Telefon *\"]//span"));
        }
    },


    //Unos cele forme
    unosCelaFormaAll: {
    value: function(naziv, nazivEng, drzava, mesto, opstina, ulicaIBroj, elektronskaPosta, webAdresa, telefon, skraceniNaziv) {
            this.naziv = naziv;
            this.nazivEng = nazivEng;
            this.drzava = drzava;
            this.mesto = mesto;
            this.opstina = opstina;
            this.ulica = ulica;
            this.elektronskaPosta = elektronskaPosta;
            this.webAdresa = webAdresa;
            this.telefon = telefon;
            this.skraceniNaziv = skraceniNaziv;

        }
},

    //Cela forma Clear all
    formaClearAll: {
    value: function() {
            this.naziv = "";
            this.nazivEng = "";
            this.drzava = "";
            this.mesto = "";
            this.opstina = "";
            this.ulicaIBroj = "";
            this.webAdresa = "";
            this.elektronskaPosta = "";
            this.telefon = "";
            this.skraceniNaziv = "";

        }
}


});

module.exports = OsnovniPodaciPage;

