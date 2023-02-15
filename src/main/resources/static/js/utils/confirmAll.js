import {postConfirmarReserva} from "../query/post.js";

const submitConfirmacion = document.getElementById("submitConfirmacion");

submitConfirmacion.addEventListener("click", confirmarReserva);

function confirmarReserva()
{
    postConfirmarReserva().then((reserva) => {
        console.log(reserva)
        if (reserva === 200) {
            alert("Reserva confirmada correctamente");
            location.reload();
            //window.location.href = "../index.html";
        } else {
            alert("Error al confirmar la reserva");
            //window.location.href = "../index.html";
        }
    })
}