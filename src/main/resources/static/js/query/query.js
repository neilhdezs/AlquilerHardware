import {URL} from "../utils/utils.js";

const getAllReservas = async () => {
    const respone = await fetch(`${URL}reservas/`)
    return respone.json()
}

const getAllReservasAulas = async () => {
    const respone = await fetch(`${URL}reservas/aulas/`)
    return respone.json()
}

const getAllReservasTablets = async () => {
    const respone = await fetch(`${URL}reservas/tablets/`)
    return respone.json()
}

const getAllReservasPcs = async () => {
    const respone = await fetch(`${URL}reservas/pcs/`)
    return respone.json()
}


export {getAllReservas, getAllReservasPcs, getAllReservasTablets, getAllReservasAulas}