import {getAllReservasAulas} from "../query/query.js";
import {checkAula, checkHours} from "../utils/utils.js";

async function insertDataTableAulas()
{
    let reservasAulas = await getAllReservasAulas();
    let table = document.getElementById("tableBodyAulas");
    console.log(reservasAulas)
    reservasAulas.forEach(reserva => {
        let row = document.createElement("tr");

        let columnaAula = document.createElement("td");
        let aula = checkAula(reserva.idAula)
        columnaAula.appendChild(document.createTextNode(aula));

        let columnaProfesor = document.createElement("td");
        columnaProfesor.appendChild(document.createTextNode(reserva.idProfesor.nombre + " " + reserva.idProfesor.apellidos));

        let columnaFecha = document.createElement("td");
        let date = new Date(reserva.reservaAulaId.fecha);
        let dateHoursMinute = checkHours(date)

        columnaFecha.appendChild(document.createTextNode(date.getDate() + "/" + (date.getMonth() + 1) + "/" + date.getFullYear() + " " + dateHoursMinute));

        row.appendChild(columnaAula);
        row.appendChild(columnaProfesor);
        row.appendChild(columnaFecha);
        table.appendChild(row);
    })
}


insertDataTableAulas();

