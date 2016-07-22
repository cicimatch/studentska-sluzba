var IstrazivacRow = require('./istrazivacRow.page.js');

var IstrazivaciPage = function() {};

IstrazivaciPage.prototype = Object.create({}, {

    // Dugme za dodavanje istraživača
    dodajIstrazivacaBtn: {
        get: function() {
            return element(by.xpath("//a[@ui-sref='addPerson']"));
        },
    },

    // Tabela istraživača
    istrazivaciTable: {
        get: function() {
            return element(by.xpath("//*[@id='page-content']//table"));
        },
    },

    // Pokupi sve <tr> tagove
    tableRows: {
        get: function() {
            return this.istrazivaciTable.all(by.tagName("tr"));
        },
    },

    // Nalazi red u tabeli (red u kojem se nalazi prosleđeno ime)
    istrazivacRowByIme:{
        value:function(imeString) {
            return this.istrazivaciTable.element(by.xpath('//*[contains(text(),"' + imeString + '")]/..'));

        }
    },

    // Nalazi red u tabeli (red u kojem se nalazi prosleđeno prezime)
    istrazivacRowByPrezime: {
        value:function(prezimeString) {
            return this.istrazivaciTable.element(by.xpath('//*[contains(text(),"' + prezimeString + '")]/..'));

        }
    },

    // Na osnovu prosleđenog prezimena klikne na istraživača, pa edit strana
    editIstrazivacByPrezime: {
      value:function(prezimeString) {

        var edit = this.istrazivacRowByPrezime(prezimeString).element(by.xpath('//td[contains(text(),"' + prezimeString + '")]/..'));
        edit.click();

      }

    },

    // Sortiranje ako nam je neophodno
    sortByIme: {
        get: function() {
            return element(by.xpath("//span[contains(text(),'Ime')]"));
        }
    },

    sortByPrezime: {
        get: function() {
            return element(by.xpath("//span[contains(text(), 'Prezime')]"));
        }
    },

    sortByDatum: {
        get: function() {
            return element(by.xpath("//span[contains(text(), 'Datum')]"));
        }
    },

    // Button u dnu stranice
    prviBtn: {
       get:function() {
            return element(by.linkText("Prvi"));

        }
    },

     prethodniBtn: {
        get: function() {
            return element(by.xpath("//a[contains(text(), 'Prethodni')]"));
        }
    },

    trenutniBtn: {
        get: function() {
            return element(by.xpath("//a[@ng-click='selectPage(page.number, $event)']"));
        }
    },

    sledeciBtn: {
        get: function() {
            return element(by.xpath("//a[contains(text(), 'Sledeći')]"));
        }
    },

    poslednjiBtn: {
        get: function() {
            return element(by.xpath("//a[contains(text(), 'Poslednji')]"));
        }
    },

    // Ovde sam stavio dugme za pretragu i ona 2 dropdown dugmeta
    pretrazivac: {
        get: function() {
            return element(by.model("value"));
        },
        set: function(value) {
            this.pretrazivac.clear();
            this.pretrazivac.sendKeys(value);
        }
    },

    migriraniPodaci: {
        get: function() {
            return element(by.name("migrated"));
        }
    },

    verifikovaniMigriraniPodaci: {
        get: function() {
            return element(by.name("changed"));
        }
    }


});

module.exports = IstrazivaciPage;
