import {getAllReservasPcs} from "../query/query.js";
import {checkHours} from "../utils/utils.js";

async function insertDataTablePcs()
{
    let reservasPcs = await getAllReservasPcs();
    let table = document.getElementById("tableBodyPcs");

    reservasPcs.forEach(reserva => {

        let row = document.createElement("tr");

        let columnaCarrito = document.createElement("td");
        columnaCarrito.appendChild(document.createTextNode(reserva.idCarritoPcs.id));

        let columnaProfesor = document.createElement("td");
        columnaProfesor.appendChild(document.createTextNode(reserva.idProfesor.nombre + " " + reserva.idProfesor.apellidos));

        let columnaFecha = document.createElement("td");
        let date = new Date(reserva.reservaCarritoPcsId.fecha);
        let dateHoursMinute = checkHours(date)
        columnaFecha.appendChild(document.createTextNode(date.getDate() + "/" + (date.getMonth() + 1) + "/" + date.getFullYear() + " " + dateHoursMinute));

        let columnaUbicacion = document.createElement("td");
        columnaUbicacion.appendChild(document.createTextNode(reserva.ubicacionPrestamo));

        row.appendChild(columnaCarrito);
        row.appendChild(columnaProfesor);
        row.appendChild(columnaFecha);
        row.appendChild(columnaUbicacion);
        table.appendChild(row);
    })
}


insertDataTablePcs();
