import {postReservaPcs} from "../query/post.js";
import {URL} from "../utils/utils.js";

const submitReservaPcs = document.getElementById("submitReservaPcs");

submitReservaPcs.addEventListener("click", crearReserva);

function crearReserva()
{
    postReservaPcs(parseoDatos()).then((reservaStatus) => {
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
    const aulaDestino = document.getElementById("aulaDestino");
    const idCarritoPc = document.getElementById("idCarritoPc");

    const dateInPost = new Date(datePicker.value + " " + timePicker.value).getTime();

    console.log( URL + "pcs/" + "?idProfesor=" + idProfesor.value + "&aulaDestino=" + aulaDestino.value + "&fecha=" + dateInPost + "&idCarritoPc=" + idCarritoPc.value)
    return URL + "pcs/" + "?idProfesor=" + idProfesor.value + "&aulaDestino=" + aulaDestino.value + "&fecha=" + dateInPost + "&idCarritoPc=" + idCarritoPc.value;
}