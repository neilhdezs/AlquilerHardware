export class ReservaPcs {
    constructor(reservaCarritoPcsId, idProfesor, idCarritoPcs, ubicacionPrestamo) {
        this._reservaCarritoPcsId = reservaCarritoPcsId;
        this._idProfesor = idProfesor;
        this._idCarritoPcs = idCarritoPcs;
        this._ubicacionPrestamo = ubicacionPrestamo;
    }


    get reservaCarritoPcsId() {
        return this._reservaCarritoPcsId;
    }

    set reservaCarritoPcsId(value) {
        this._reservaCarritoPcsId = value;
    }

    get idProfesor() {
        return this._idProfesor;
    }

    set idProfesor(value) {
        this._idProfesor = value;
    }

    get idCarritoPcs() {
        return this._idCarritoPcs;
    }

    set idCarritoPcs(value) {
        this._idCarritoPcs = value;
    }

    get ubicacionPrestamo() {
        return this._ubicacionPrestamo;
    }

    set ubicacionPrestamo(value) {
        this._ubicacionPrestamo = value;
    }
}