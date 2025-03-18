const {NganhHoc} = require('../models/nganhhoc')

exports.getNganhHoc_1 = async (req,res)  => {
    try {
        let dataNganhHoc_1 = await NganhHoc.getNganhHoc_1();
        res.status(200).json(dataNganhHoc_1);
    } catch (e) {
        console.error(e);
        res.status(500).json({ error: `Database error: ${e.message}` });
    }
}
exports.getNganhHoc_2 = async (req,res)  => {
    try {
        let dataNganhHoc_2 = await NganhHoc.getNganhHoc_2();
        res.status(200).json(dataNganhHoc_2);
    } catch (e) {
        console.error(e);
        res.status(500).json({ error: `Database error: ${e.message}` });
    }
}