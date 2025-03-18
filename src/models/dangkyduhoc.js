const { sql, poolPromise } = require('../config/databaseSqlServer')


const DangKyDuHoc = {
    getDangKyDuHoc_1: async () => {
        try {
            let pool = await poolPromise;
            let result = await pool.request().query('SELECT * FROM DangKy_1');
            return result.recordset;
        } catch (err) {
            throw err
        }

    },
    getDangKyDuHoc_2: async () => {
        try {
            let pool = await poolPromise;
            let result = await pool.request().query('SELECT * FROM DangKy_2');
            return result.recordset;
        } catch (err) {
            throw err;
        }

    },
    getDangKyDuHoc_3: async () => {
        try {
            let pool = await poolPromise;
            let result = await pool.request().query('SELECT * FROM DangKy_3');
            return result.recordset;
        } catch (err) {
            throw err;

        }

    },
   
}

module.exports = { DangKyDuHoc }