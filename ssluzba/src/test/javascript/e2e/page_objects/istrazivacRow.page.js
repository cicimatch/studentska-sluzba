var IstrazivacRow = function(rowElement) {
  this.rowElement = rowElement;
}

IstrazivacRow.prototype = Object.create({}, {
  
  
  // Ime value
  ime: {
    get: function() {
      return this.rowElement.element(by.xpath("//span[contains(text(),'Ime')]")).getText();
    }
  },
  
  // Prezime value
  prezime: {
    get: function() {
      return this.rowElement.element(by.xpath("//span[contains(text(), 'Prezime')]")).getText();
    }
  },

  // Datum value
  datum: {
    get: function() {
      return this.rowElement.element(by.xpath("//span[contains(text(), 'Datum')]")).getText();
    }
  }

  });

module.exports = IstrazivacRow;