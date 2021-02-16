function OnSubmit() {
    document.getElementById("length").innerHTML = "Length is of input is: ";
    document.getElementById("string").innerHTML = "Displaying in UpperCase and LowerCase:";
    document.getElementById("vowelsAndConsonants").innerHTML = "Separating Vowels and consonants:";
    document.getElementById("numbers").innerHTML = "Checking if theres a number in the input:";

    let b = document.getElementById("text");
    document.getElementById("length").innerHTML += '\n' + b.value.length;
    document.getElementById("string").innerHTML += '\n' + b.value.toUpperCase() + " " + b.value.toLowerCase();

    function vowelsAndConsonants(s) {
        const vowels = 'aeiou';
        const consonants = 'bcdfghjklmnpqrstvwxyz'
        const CapVowels = vowels.toUpperCase();
        const CapCon = consonants.toUpperCase();
        var con = [];
        var vow = [];
        for (var i = 0; i < s.length; i++) {
            if (vowels.includes(s[i]) || CapVowels.includes(s[i])) {
                vow += s[i];
            } else if (consonants.includes(s[i]) || CapCon.includes(s[i])) {
                con += s[i];
            }
        }
        return [vow, con];
    }

    var arr = vowelsAndConsonants(b.value);
    document.getElementById("vowelsAndConsonants").innerHTML += '\n' + arr[0].toString() + "   " + arr[1].toString();


    if (b.value.search("[0-9]") !== -1) {
        document.getElementById("numbers").innerHTML += '\n' + "Input is invalid, enter string without numbers";
        throw new Error("Input is invalid, enter string without numbers");
    } else {
        document.getElementById("numbers").innerHTML += '\n' + "Input has no numbers present in it!!";
    }

}