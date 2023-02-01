import {postCancelarReserva} from "../query/post.js";
import {URL} from "../utils/utils.js";

const deleteReserva = document.getElementById("deleteReserva");

deleteReserva.addEventListener("click", postCancelarReservaAula);

function postCancelarReservaAula()
{
    const selectionReserva = document.getElementById("selectionReserva");

    const date = new Date(document.getElementById("datePicker").value + " " + document.getElementById("timePicker").value);

    const id = document.getElementById("idInput");

    let url = URL;

    if (selectionReserva.value === "aula") {
        url = url + "cancelarAula/" + "?idAula=" + id.value + "&fecha=" + date.getTime();
    }
    else if (selectionReserva.value === "pc") {
        url = url + "cancelarOrdenadores/" + "?fecha=" + date.getTime() + "&idCarritoPcs=" + id.value;
    }
    else
    {
        url = url + "cancelarTablets/" + "?fecha=" + date.getTime() + "&idCarritoTablets=" + id.value;
    }


    postCancelarReserva(url).then((reservaStatus) => {
        console.log(reservaStatus)
        if (reservaStatus === 200) {
            alert("Reserva cancelada correctamente");
            //window.location.href = "../index.html";
        } else if (reservaStatus === 420) {
            alert("Error al cancelar la reserva, la reserva no existe");
            //window.location.href = "../index.html";
        }
        else {
            alert("Error al cancelar la reserva");
            //window.location.href = "../index.html";
        }
    })
}


