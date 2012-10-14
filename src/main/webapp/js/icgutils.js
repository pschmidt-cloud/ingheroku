/* start of third party functions */
$.fn.dataTableExt.oApi.fnReloadAjax = function (oSettings, sNewSource, fnCallback, bStandingRedraw) {
    if (typeof sNewSource != 'undefined' && sNewSource != null) {
        oSettings.sAjaxSource = sNewSource;
    }
    this.oApi._fnProcessingDisplay(oSettings, true);
    var that = this;
    var iStart = oSettings._iDisplayStart;
    var aData = [];

    this.oApi._fnServerParams(oSettings, aData);

    oSettings.fnServerData(oSettings.sAjaxSource, aData, function(json) {
        /* Clear the old information from the table */
        that.oApi._fnClearTable(oSettings);

        /* Got the data - add it to the table */
        var aData = (oSettings.sAjaxDataProp !== "") ?
            that.oApi._fnGetObjectDataFn(oSettings.sAjaxDataProp)(json) : json;

        for (var i = 0; i < aData.length; i++) {
            that.oApi._fnAddData(oSettings, aData[i]);
        }

        oSettings.aiDisplay = oSettings.aiDisplayMaster.slice();
        that.fnDraw();

        if (typeof bStandingRedraw != 'undefined' && bStandingRedraw === true) {
            oSettings._iDisplayStart = iStart;
            that.fnDraw(false);
        }

        that.oApi._fnProcessingDisplay(oSettings, false);

        /* Callback user function - for event handlers etc */
        if (typeof fnCallback == 'function' && fnCallback != null) {
            fnCallback(oSettings);
        }
    }, oSettings);
}

$.fn.clearForm = function() {
    $('#firstName').val('');
    $('#lastName').val('');
    $('#userName').val('');
    $('#shipAddress').val('');
    $('#partnerOrderId').val('');
    $('#quantity').val('');
    $('#valueType').val(0);
    $('#couponId').val('');
    $('#skus').prop("selectedIndex", 0);
    $('#restrictedUsers').val('');
    $('#purchaseOrder').removeAttr('checked');
    $('#purchaseOrder').prop('disabled', true);
    couponTypeSelectHandler();
};

function validateForm(form) {
   if (!isValidEmail(form.userName.value)) {
       alert("Not a valid e-mail address");
       return false;
   }

   if (!isNumeric(form.quantity.value)) {
      alert('Please enter only numbers in the quantity field')
      return false;
   }

    return true;
}

function isNumeric(sText) {
   var ValidChars = "0123456789.";
   var IsNumber=true;
   var Char;

   for (i = 0; i < sText.length && IsNumber == true; i++) {
      Char = sText.charAt(i);
      if (ValidChars.indexOf(Char) == -1) {
         IsNumber = false;
      }
   }

   return IsNumber;
}

function isValidEmail(sText) {
    var x = sText;
    var atpos = x.indexOf("@");
    var dotpos = x.lastIndexOf(".");
    if (atpos < 1 || dotpos < atpos + 2 || dotpos + 2 >= x.length) {
        return false;
    }
    return true;
}
/* end of third party functions */