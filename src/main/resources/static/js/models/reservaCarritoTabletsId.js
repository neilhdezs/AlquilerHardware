export class ReservaCarritoTabletsId {
    constructor(idCarritoTablets, fecha) {
        this._idCarritoTablets = idCarritoTablets;
        this._fecha = fecha;
    }


    get idCarritoTablets() {
        return this._idCarritoTablets;
    }

    set idCarritoTablets(value) {
        this._idCarritoTablets = value;
    }

    get fecha() {
        return this._fecha;
    }

    set fecha(value) {
        this._fecha = value;
    }
}