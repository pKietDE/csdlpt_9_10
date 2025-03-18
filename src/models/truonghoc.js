const { sql, poolPromise } = require('../config/databaseSqlServer')


const TruongHoc = {
    getTruongHoc_1: async () => {
        try {
            let pool = await poolPromise;
            let result = await pool.request().query('SELECT * FROM TruongHoc_1');
            return result.recordset;
        } catch (err) {
            throw err
        }

    },
    getTruongHoc_2: async () => {
        try {
            let pool = await poolPromise;
            let result = await pool.request().query('SELECT * FROM TruongHoc_2');
            return result.recordset;
        } catch (err) {
            throw err;
        }

    },
    getTruongHoc_3: async () => {
        try {
            let pool = await poolPromise;
            let result = await pool.request().query('SELECT * FROM TruongHoc_3');
            return result.recordset;
        } catch (err) {
            throw err;

        }

    },
    getTruongHoc_4: async () => {
        try {
            let pool = await poolPromise;
            let result = await pool.request().query('SELECT * FROM TruongHoc_4');
            return result.recordset;
        } catch (err) {
            throw err;
        }
    },
}

module.exports = { TruongHoc }