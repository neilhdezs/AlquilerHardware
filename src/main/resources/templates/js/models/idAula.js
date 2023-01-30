export class IdAula {
    constructor(id, numeroAula, planta) {
        this._id = id;
        this._numeroAula = numeroAula;
        this._planta = planta;
    }


    get id() {
        return this._id;
    }

    set id(value) {
        this._id = value;
    }

    get numeroAula() {
        return this._numeroAula;
    }

    set numeroAula(value) {
        this._numeroAula = value;
    }

    get planta() {
        return this._planta;
    }

    set planta(value) {
        this._planta = value;
    }
}