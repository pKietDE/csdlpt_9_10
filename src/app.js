const express = require('express')
const app = express()
const truonghoc_router = require("./router/truonghoc_router.js")
const duhocsinh_router = require("./router/duhocsinh_router.js")
const nganhhoc_router = require("./router/nganhhoc_router.js")
const dangkyduhoc_router = require("./router/dangkyduhoc_router.js")
const port = "3000"


app.use(express.json());
app.use("/truonghoc",truonghoc_router)
app.use("/duhocsinh",duhocsinh_router)
app.use("/nganhhoc",nganhhoc_router)
app.use("/dangkyduhoc",dangkyduhoc_router)

app.listen(port, '0.0.0.0', () => {
    console.log("Server is Running")
})