export class ReservaAulas {
    constructor(reservaAulaId, idProfesor, idAula) {
        this._reservaAulaId = reservaAulaId;
        this._idProfesor = idProfesor;
        this._idAula = idAula;
    }


    get reservaAulaId() {
        return this._reservaAulaId;
    }

    set reservaAulaId(value) {
        this._reservaAulaId = value;
    }

    get idProfesor() {
        return this._idProfesor;
    }

    set idProfesor(value) {
        this._idProfesor = value;
    }

    get idAula() {
        return this._idAula;
    }

    set idAula(value) {
        this._idAula = value;
    }
}