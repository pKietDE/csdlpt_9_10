const { sql, poolPromise } = require('../config/databaseSqlServer')


const NganhHoc = {
    getNganhHoc_1: async () => {
        try {
            let pool = await poolPromise;
            let result = await pool.request().query('SELECT * FROM NganhHoc_1');
            return result.recordset;
        } catch (err) {
            throw err
        }

    },
    getNganhHoc_2: async () => {
        try {
            let pool = await poolPromise;
            let result = await pool.request().query('SELECT * FROM NganhHoc_2');
            return result.recordset;
        } catch (err) {
            throw err;
        }

    },
   
}

module.exports = { NganhHoc }