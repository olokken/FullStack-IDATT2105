import express from "express";
import cors from "cors";

const app = express();
const port = 3000;

const allowedOrigins = ["http://localhost:8080"];

const options: cors.CorsOptions = {
  origin: allowedOrigins,
};

app.use(cors(options));
app.use(express.json());

const server = app.listen(port, () => {
  console.log("Listening on port " + port);
});

app.post("/", (req: any, res: any) => {
  console.log(req.params);
  req.send(10);
});
