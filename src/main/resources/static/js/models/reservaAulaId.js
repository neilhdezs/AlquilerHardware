export class ReservaAulaId {

    constructor(idAula, fecha) {
        this._idAula = idAula;
        this._fecha = fecha;
    }

    get idAula() {
        return this._idAula;
    }

    set idAula(value) {
        this._idAula = value;
    }

    get fecha() {
        return this._fecha;
    }

    set fecha(value) {
        this._fecha = value;
    }
}