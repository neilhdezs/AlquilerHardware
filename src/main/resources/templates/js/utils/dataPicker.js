let timePicker = document.getElementById("timePicker");

let horasDisponibles = ["08:15", "09:15", "10:15", "11:15", "11:45", "12:45", "13:45"];

let opciones = "";
horasDisponibles.forEach(function(hora) {
    opciones += `<option value="${hora}">${hora}</option>`;
});

// Agrega las opciones al time picker
timePicker.innerHTML = opciones;
