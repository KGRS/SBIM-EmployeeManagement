
function GetNumber2d(form) {
    var gf = ""
    var gg = ""
    var gh = ""
    var gi = ""
    var gj = ""
    var gc = "zero"
    var dd = ""
    var cc = ""

    var sNumber = form.txtNumber.value;
    var sNumbec = form.txtNumbe2.value;

    sNumber = stripBad(sNumber);
    sNumber = parseInt(sNumber, 10);
    var sNum2 = String(sNumber);

    sNumbec = stripBad(sNumbec);
    sNumbec = parseInt(sNumbec, 10);
    var sNumc = String(sNumbec);

    if (sNumber == 1){
        dd = " dollar "
        }
    else {
        dd = " dollars "
        }
    if (sNumbec == 1){
        cc = " cent"
        }
    else {
        cc = " cents"
        }

    if (sNumbec < 1){
        gc = "zero"
        }
    if (sNumc=="") {
        gc = "zero"
        }
    if (sNumc > 0) {
        gc = hto(sNumc)
        }

    var j =  sNum2.length
    var hNum2 = sNum2.substring((j-3),((j-3)+3))

    if (hNum2 > 0) {
        gf = hto(hNum2) + ""
    }

    var tNum2 = sNum2.substring((j-6),(j-6)+3)
    if (tNum2 > 0) {
        gg = hto(tNum2) + " thousand "
    }

    var mNum2 = sNum2.substring((j-9),(j-9)+3)
    if (mNum2 > 0) {
        gh = hto(mNum2) + " million "
    }

    var bNum2 = sNum2.substring((j-12),(j-12)+3)
    if (bNum2 > 0) {
        gi = hto(bNum2) + " billion "
    }

    var trNum2 = sNum2.substring((j-15),(j-15)+3)
    if (trNum2 > 0) {
        gj = hto(trNum2) + " trillion "
    }

    if (sNumber < 1){
        gf = "zero"
    }

    if (j > 15){
        gj = " Your number is too big for me to spell";
        gi = "";
        gh = "";
        gg = "";
        gf = "";
    }
    var dds = gj + gi + gh + gg + gf;
    if (dds == ""){
        dds = "zero"
        }

    form.txtResult.value= " " + dds + dd + "  and   " + gc + " " + cc
    }

function GetNumber2e(form) {
    var gf = ""
    var gg = ""
    var gh = ""
    var gi = ""
    var gj = ""
    var gc = "zero"
    var dd = ""
    var cc = ""

    var sNumber = form.txtNumber.value;
    var sNumbec = form.txtNumbe2.value;

    sNumber = stripBad(sNumber);
    sNumber = parseInt(sNumber, 10);
    var sNum2 = String(sNumber);

    sNumbec = stripBad(sNumbec);
    sNumbec = parseInt(sNumbec, 10);
    var sNumc = String(sNumbec);

    dd = " euro ";
    cc = " cent";


    if (sNumbec < 1){
        gc = "zero"
        }
    if (sNumc=="") {
        gc = "zero"
        }
    if (sNumc > 0) {
        gc = hto(sNumc)
        }

    var j =  sNum2.length
    var hNum2 = sNum2.substring((j-3),((j-3)+3))

    if (hNum2 > 0) {
        gf = hto(hNum2) + ""
    }

    var tNum2 = sNum2.substring((j-6),(j-6)+3)
    if (tNum2 > 0) {
        gg = hto(tNum2) + " thousand "
    }

    var mNum2 = sNum2.substring((j-9),(j-9)+3)
    if (mNum2 > 0) {
        gh = hto(mNum2) + " million "
    }

    var bNum2 = sNum2.substring((j-12),(j-12)+3)
    if (bNum2 > 0) {
        gi = hto(bNum2) + " billion "
    }

    var trNum2 = sNum2.substring((j-15),(j-15)+3)
    if (trNum2 > 0) {
        gj = hto(trNum2) + " trillion "
    }

    if (sNumber < 1){
        gf = "zero"
    }

    if (j > 15){
        gj = " Your number is too big for me to spell";
        gi = "";
        gh = "";
        gg = "";
        gf = "";
    }
    var dds = gj + gi + gh + gg + gf;
    if (dds == ""){
        dds = "zero"
        }

    form.txtResult.value= " " + dds + dd + "  and   " + gc + " " + cc
    }




function GetNumber2(form) {
    var gf = ""
    var gg = ""
    var gh = ""
    var gi = ""
    var gj = ""

    var sNumber = form.txtNumber.value;
    sNumber = stripBad(sNumber);
    sNumber = parseInt(sNumber, 10);
    var sNum2 = String(sNumber);

    var j =  sNum2.length
    var hNum2 = sNum2.substring((j-3),((j-3)+3))

    if (hNum2 > 0) {
        gf = hto(hNum2) + ""
    }

    var tNum2 = sNum2.substring((j-6),(j-6)+3)
    if (tNum2 > 0) {
        gg = hto(tNum2) + " thousand "
    }

    var mNum2 = sNum2.substring((j-9),(j-9)+3)
    if (mNum2 > 0) {
        gh = hto(mNum2) + " million "
    }

    var bNum2 = sNum2.substring((j-12),(j-12)+3)
    if (bNum2 > 0) {
        gi = hto(bNum2) + " billion "
    }

    var trNum2 = sNum2.substring((j-15),(j-15)+3)
    if (trNum2 > 0) {
        gj = hto(trNum2) + " trillion "
    }

    if (sNumber < 1){
        gf = "zero"
    }

    if (j > 15){
        gj = " Your number is too big for me to spell";
        gi = "";
        gh = "";
        gg = "";
        gf = "";
    }

    form.txtResult.value= " " + gj + gi + gh + gg + gf
}



function GetNumber3(form) {
    var gf = ""
    var gg = ""
    var gh = ""
    var gi = ""
    var gj = ""
    var gs = "s"
    var n3 = new Array('', 'tenth', 'hundredth', 'thousandth', 'ten-thousandth', 'hundred-thousandth',
        'millionth', 'ten-millionth', 'hundred-millionth', 'billionth', 'ten-billionth', 'hundred-billionth',
        'trillionth', 'ten-trillionth', 'hundred-trillionth')

    var sNumber = form.txtNumber.value;
    sNumber = stripBad2(sNumber);
    var jz = sNumber.length
    sNumber = parseInt(sNumber, 10);
    if (sNumber == 1) {
        gs = ""
        }

    var sNum2 = String(sNumber);

    var j =  sNum2.length
    var hNum2 = sNum2.substring((j-3),((j-3)+3))

    if (hNum2 > 0) {
        gf = hto(hNum2) + ""
    }

    var tNum2 = sNum2.substring((j-6),(j-6)+3)
    if (tNum2 > 0) {
        gg = hto(tNum2) + " thousand "
    }

    var mNum2 = sNum2.substring((j-9),(j-9)+3)
    if (mNum2 > 0) {
        gh = hto(mNum2) + " million "
    }

    var bNum2 = sNum2.substring((j-12),(j-12)+3)
    if (bNum2 > 0) {
        gi = hto(bNum2) + " billion "
    }

    var trNum2 = sNum2.substring((j-15),(j-15)+3)
    if (trNum2 > 0) {
        gj = hto(trNum2) + " trillion "
    }

    if (sNumber < 1){
        gf = "zero"
    }

    if (jz > 14){
        gj = " Your number is too small for me to spell";
        gi = "";
        gh = "";
        gg = "";
        gf = "";
        gs = "";
        n3[jz]= "";

    }


    form.txtResult.value= " " + gj + gi + gh + gg + gf + " " + n3[jz] + gs
    }

function GetNumber5(form) {
    var gf = "";
    var gg = "";
    var gh = "";
    var gi = "";
    var gj = "";

    var sNumber = form.txtNumber.value;
    sNumber = stripBad(sNumber);
    sNumber = parseInt(sNumber, 10);
    var sNum2 = String(sNumber);
    var j =  sNum2.length;
    var hNum2 = sNum2.substring((j-3),((j-3)+3))

    if (hNum2 > 0) {
        gf = hto(hNum2) + ""
    }

    var tNum2 = sNum2.substring((j-6),(j-6)+3)
    if (tNum2 > 0) {
        gg = hto(tNum2) + " thousand "
    }

    var mNum2 = sNum2.substring((j-9),(j-9)+3)
    if (mNum2 > 0) {
        gh = hto(mNum2) + " million "
    }

    var bNum2 = sNum2.substring((j-12),(j-12)+3)
    if (bNum2 > 0) {
        gi = hto(bNum2) + " billion "
    }

    var trNum2 = sNum2.substring((j-15),(j-15)+3)
    if (trNum2 > 0) {
        gj = hto(trNum2) + " trillion "
    }

    if (sNumber < 1){
        gf = "zero"
    }

    if (j > 15){
        gj = " Your number is too big for me to spell";
        gi = "";
        gh = "";
        gg = "";
        gf = "";
    }

    var df = "";
    var dg = "";
    var dh = "";
    var di = "";
    var dj = "";
    var gs = "s";
    var n3 = new Array('', 'tenth', 'hundredth', 'thousandth', 'ten-thousandth', 'hundred-thousandth',
        'millionth', 'ten-millionth', 'hundred-millionth', 'billionth', 'ten-billionth', 'hundred-billionth',
        'trillionth', 'ten-trillionth', 'hundred-trillionth')

    var dNumber = form.txtNumbe2.value;
    dNumber = stripBad2(dNumber);
    var jz = dNumber.length
    dNumber = parseInt(dNumber, 10);

    if (dNumber == 1) {
        gs = ""
        }
    var dNum2 = String(dNumber);

    var j =  dNum2.length
    var hNum2 = dNum2.substring((j-3),((j-3)+3))

    if (hNum2 > 0) {
        df = hto(hNum2) + ""
    }

    var tNum2 = dNum2.substring((j-6),(j-6)+3)
    if (tNum2 > 0) {
        dg = hto(tNum2) + " thousand "
    }

    var mNum2 = dNum2.substring((j-9),(j-9)+3)
    if (mNum2 > 0) {
        dh = hto(mNum2) + " million "
    }

    var bNum2 = dNum2.substring((j-12),(j-12)+3)
    if (bNum2 > 0) {
        di = hto(bNum2) + " billion "
    }

    var trNum2 = dNum2.substring((j-15),(j-15)+3)
    if (trNum2 > 0) {
        dj = hto(trNum2) + " trillion "
    }

    if (dNumber < 1){
        df = "zero"
    }

    if (jz > 14){
        dj = " Your number is too small for me to spell";
        di = "";
        dh = "";
        dg = "";
        df = "";
        gs = "";
        n3[jz]= "";

    }


    form.txtResult.value= " " + gj + gi + gh + gg + gf + " and " + dj + di + dh + dg + df + " " + n3[jz] + gs
    }


function GetNumber4(form) {
    var gf = ""
    var gg = ""
    var gh = ""
    var gi = ""
    var gj = ""

    var sNumber = form.txtNumber.value;
    sNumber = stripBad(sNumber);
    sNumber = parseInt(sNumber, 10);
    var sNum2 = String(sNumber);

    var j =  sNum2.length
    var hNum2 = sNum2.substring((j-3),((j-3)+3))

    if (hNum2 > 0) {
        gf = ohto(hNum2) + ""
    }

    var tNum2 = sNum2.substring((j-6),(j-6)+3)
    if ((tNum2 > 0)&&(hNum2 > 0)) {
        gg = hto(tNum2) + " thousand "
    }

    else if ((tNum2 > 0)&&(hNum2 == 0)) {
        gg = hto(tNum2) + " thousandth "
    }


    var mNum2 = sNum2.substring((j-9),(j-9)+3)
    var tNum6 = sNum2.substring((j-6),(j-6)+6)

    if ((mNum2 > 0)&&(tNum6 > 0)) {
        gh = hto(mNum2) + " million "
    }

    else if ((mNum2 > 0)&&(tNum6 == 0)) {
        gh = hto(mNum2) + " millionth "
    }

    var bNum2 = sNum2.substring((j-12),(j-12)+3)
    var tNum9 = sNum2.substring((j-9),(j-9)+9)

    if ((bNum2 > 0)&&(tNum9 > 0)) {
        gi = hto(bNum2) + " billion "
    }
    else if ((bNum2 > 0)&&(tNum9 == 0)) {
        gi = hto(bNum2) + " billionth "
    }


    var trNum2 = sNum2.substring((j-15),(j-15)+3)
    var tNum12 = sNum2.substring((j-12),(j-12)+12)

    if ((trNum2 > 0)&&(tNum12 > 0)) {
        gj = hto(trNum2) + " trillion "
    }

    else if ((trNum2 > 0)&&(tNum12 == 0)) {
        gj = hto(trNum2) + " trillionth "
    }

    if (sNumber < 1){
        gf = "zero cannot be an ordinal number"
    }

    if (j > 15){
        gj = " Your number is too big for me to spell";
        gi = "";
        gh = "";
        gg = "";
        gf = "";
    }

    form.txtResult.value= " " + gj + gi + gh + gg + gf
}



function stripBad(string) {
    for (var i=0, output='', valid="0123456789."; i<string.length; i++)
        if (valid.indexOf(string.charAt(i)) != -1)
            output += string.charAt(i)
    return output;
}

function stripBad2(string) {
    for (var i=0, output='', valid="0123456789"; i<string.length; i++)
        if (valid.indexOf(string.charAt(i)) != -1)
            output += string.charAt(i)
    return output;
}

function hto(ff){
    var sNum3 = ""
    var p1=""
    var p2=""
    var p3=""

    var hy=""
    var n1 = new Array
    ('', 'one', 'two', 'three', 'four', 'five', 'six',
        'seven', 'eight', 'nine', 'ten', 'eleven', 'twelve',
        'thirteen', 'fourteen', 'fifteen',  'sixteen', 'seventeen',
        'eighteen', 'nineteen')

    var n2 = new Array('', '', 'twenty', 'thirty', 'forty',
        'fifty', 'sixty', 'seventy', 'eighty', 'ninety')


    sNum3 = ff
    var j =  sNum3.length
    var h3 = sNum3.substring((j-3),(j-3)+1)
    if (h3 > 0) {
        p3= n1[h3] + " hundred "
        }
    else {
        p3=""
        }

    var t2 = parseInt(sNum3.substring((j-2),(j-2)+1), 10)
    var u1 = parseInt(sNum3.substring((j-1),(j-1)+1), 10)
    var tu21 = parseInt(sNum3.substring((j-2),(j-2)+2), 10)

    if (tu21 == 0) {
        p1="";
        p2="";
    }

    else if ((t2 < 1) && (u1 > 0)) {
        p2="";
        p1= n1[u1]
    }

    else if (tu21 < 20) {
        p2="";
        p1= n1[tu21]
    }

    else if ((t2 > 1) && (u1 == 0)) {
        p2= n2[t2]
        p1=""
    }

    else {
        p2= n2[t2] + "-"
        p1=n1[u1]
    }

    ff = p3 + p2 + p1

    return ff;
}

function ohto(ff){
    var sNum3 = ""
    var p1=""
    var p2=""
    var p3=""

    var hy=""
    var n1 = new Array
    ('', 'first', 'second', 'third', 'fourth', 'fifth', 'sixth',
        'seventh', 'eighth', 'ninth', 'tenth', 'eleventh', 'twelfth',
        'thirteenth', 'fourteenth', 'fifteenth',  'sixteenth', 'seventeenth',
        'eighteenth', 'nineteenth')

    var n2 = new Array('', '', 'twentieth', 'thirtieth', 'fortieth',
        'fiftieth', 'sixtieth', 'seventieth', 'eightieth', 'ninetieth')

    var n3 = new Array('', '', 'twenty', 'thirty', 'forty',
        'fifty', 'sixty', 'seventy', 'eighty', 'ninety')

    var n4 = new Array
    ('', 'one', 'two', 'three', 'four', 'five', 'six',
        'seven', 'eight', 'nine', 'ten', 'eleven', 'twelve',
        'thirteen', 'fourteen', 'fifteen',  'sixteen', 'seventeen',
        'eighteen', 'nineteen')


    sNum3 = ff
    var j =  sNum3.length
    var h3 = sNum3.substring((j-3),(j-3)+1)
    if (h3 > 0) {
        p3= n4[h3] + " hundred "
        }
    else {
        p3=""
        }

    var t2 = parseInt(sNum3.substring((j-2),(j-2)+1), 10)
    var u1 = parseInt(sNum3.substring((j-1),(j-1)+1), 10)
    var tu21 = parseInt(sNum3.substring((j-2),(j-2)+2), 10)

    if (tu21 == 0) {
        p1="";
        p2="";
        p3= n4[h3] + " hundredth "
    }

    else if ((t2 < 1) && (u1 > 0)) {
        p2="";
        p1= n1[u1]
    }

    else if (tu21 < 20) {
        p2="";
        p1= n1[tu21]
    }

    else if ((t2 > 1) && (u1 == 0)) {
        p2= n2[t2]
        p1=""
    }

    else {
        p2= n3[t2] + "-"
        p1=n1[u1]
    }

    ff = p3 + p2 + p1

    return ff;
}




function gesult(ff){

    if (Number.prototype.toFixed) {
        ff = ff.toFixed(2);
        ff = parseFloat(ff);
    }
    else {
        var leftSide = Math.floor(ff);
        var rightSide = ff - leftSide;
        ff = leftSide + Math.round(rightSide *1e+14)/1e+14;
    }

    return comma(ff);
}

function comma(num) {
    var n = Math.floor(num);
    var myNum = num + "";
    var myDec = ""

    if (myNum.indexOf('.',0) > -1){
        myDec = myNum.substring(myNum.indexOf('.',0),myNum.length);
    }

    var arr=new Array('0'), i=0;
    while (n>0)
    {
        arr[i]=''+n%1000;
        n=Math.floor(n/1000);
        i++;
    }
    arr=arr.reverse();
    for (var i in arr) if (i>0)
        while (arr[i].length<3) arr[i]='0'+arr[i];
    return arr.join() + myDec;
}