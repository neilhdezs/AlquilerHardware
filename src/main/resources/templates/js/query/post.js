import {URL} from "../utils/utils.js";

const postReservaAula = async (url) => {
    const respone = await fetch(url, {
        method: 'POST',
    })
    return respone.status
}

const postReservaPcs = async (url) => {
    const respone = await fetch(url, {
        method: 'POST',
    })
    return respone.status
}

const postReservaTablets = async (url) => {
    const respone = await fetch(url, {
        method: 'POST',
    })
    return respone.status
}

const postConfirmarReserva = async () => {
    const respone = await fetch(URL + "confirmar/", {
        method: 'POST',
    })
    return respone.status
}

const postCancelarReserva = async (url) => {
    const respone = await fetch(url, {
        method: 'DELETE',
    })
    return respone.status
}

export {postReservaAula, postConfirmarReserva, postReservaPcs, postReservaTablets, postCancelarReserva}