import {postReservaAula} from "../query/post.js";
import {URL} from "../utils/utils.js";

const submitReservaAula = document.getElementById("submitReservaAula");

submitReservaAula.addEventListener("click", crearReserva);

function crearReserva()
{
    postReservaAula(parseoDatos()).then((reservaStatus) => {
        console.log(reservaStatus)
        if (reservaStatus === 200) {
            alert("Reserva creada correctamente, Por confirmar");
            //window.location.href = "../index.html";
        } else if (reservaStatus === 495) {
          alert("No se puede realizar una reserva en fin de semana")
        } else {
            alert("Error al crear la reserva");
            //window.location.href = "../index.html";
        }
    });
}


function parseoDatos()
{

    const timePicker = document.getElementById("timePicker");
    const datePicker = document.getElementById("datePicker");
    const idProfesor = document.getElementById("idProfesor");
    const idAula = document.getElementById("idAula");

    const dateInPost = new Date(datePicker.value + " " + timePicker.value).getTime();

    return URL + "aula/" + "?idProfesor=" + idProfesor.value + "&idAula=" + idAula.value + "&fecha=" + dateInPost;
}