import express, { Router } from "express";
import cors from "cors";

const app = express();
const port = 3000;

app.use(cors());
app.use(express.json());

const server = app.listen(port, () => {
  console.log("Listening on port " + port);
});

app.post("/calc", (req: any, res: any) => {
  const result = eval(req.body["calculation"]);
  res.send({ result: result });
});

