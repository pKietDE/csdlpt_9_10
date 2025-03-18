const { sql, poolPromise } = require('../config/databaseSqlServer')


const DuHocSinh = {
    getDuHocSinh_1: async () => {
        try {
            let pool = await poolPromise;
            let result = await pool.request().query('SELECT * FROM DuHocSinh_1');
            return result.recordset;
        } catch (err) {
            throw err
        }

    },
    getDuHocSinh_2: async () => {
        try {
            let pool = await poolPromise;
            let result = await pool.request().query('SELECT * FROM DuHocSinh_2');
            return result.recordset;
        } catch (err) {
            throw err;
        }

    },
    getDuHocSinh_3: async () => {
        try {
            let pool = await poolPromise;
            let result = await pool.request().query('SELECT * FROM DuHocSinh_3');
            return result.recordset;
        } catch (err) {
            throw err;

        }

    },
   
}

module.exports = { DuHocSinh }