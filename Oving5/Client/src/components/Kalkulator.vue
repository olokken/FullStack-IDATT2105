<template>
  <div class="kalkulator">
    <div class="display">{{ regneStykke || 0 }}</div>
    <div class="kalkulator-knapper">
      <button class="kalkulator-knapp er-clear" @click="clear">C</button>
      <button class="kalkulator-knapp" @click="leggTilForgjeSvar">ANS</button>
      <button class="kalkulator-knapp" @click="deleteOne">DEL</button>
      <button class="kalkulator-knapp" @click="add('+')">&plus;</button>
      <button class="kalkulator-knapp" @click="add(1)">1</button>
      <button class="kalkulator-knapp" @click="add(2)">2</button>
      <button class="kalkulator-knapp" @click="add(3)">3</button>
      <button class="kalkulator-knapp" @click="add('-')">&minus;</button>
      <button class="kalkulator-knapp" @click="add(4)">4</button>
      <button class="kalkulator-knapp" @click="add(5)">5</button>
      <button class="kalkulator-knapp" @click="add(6)">6</button>
      <button class="kalkulator-knapp" @click="add('*')">&times;</button>
      <button class="kalkulator-knapp" @click="add(7)">7</button>
      <button class="kalkulator-knapp" @click="add(8)">8</button>
      <button class="kalkulator-knapp" @click="add(9)">9</button>
      <button class="kalkulator-knapp" @click="add('/')">&divide;</button>
      <button class="kalkulator-knapp"></button>
      <button class="kalkulator-knapp" @click="add(0)">0</button>
      <button class="kalkulator-knapp" @click="add('.')">.</button>
      <button class="kalkulator-knapp er-lik" @click="calculate">
        &equals;
      </button>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      regneStykke: "",
      forgjeSvar: null,
    };
  },
  methods: {
    clear() {
      this.regneStykke = "";
    },
    add(addedValue) {
      this.regneStykke += addedValue;
    },
    deleteOne() {
      let tempVerdi = this.regneStykke.slice(0, -1);
      this.regnestykke = "";
      this.regneStykke = tempVerdi;
    },
    calculate() {
      const onExecute = async () => {
        const response = await fetch("http://localhost:3000/calc", {
          method: "POST",
          headers: {
            Accept: "application/json",
            "Content-Type": "application/json",
          },
          body: JSON.stringify({ calculation: this.regneStykke }),
        });
        try {
          const { result } = await response.json();
          let tempVerdi = result;
          let loggInfo = this.regneStykke + " = " + tempVerdi;
          this.$emit("legg-til-logg", loggInfo);
          this.regneStykke = tempVerdi;
          this.forgjeSvar = tempVerdi;
        } catch {
          alert("du har skrevet noe feil");
        }
      };
      onExecute();
    },

    leggTilForgjeSvar() {
      if (this.forgjeSvar != null) {
        this.regneStykke += this.forgjeSvar;
      }
    },
  },
};
</script>

<style scoped>
* {
  box-sizing: border-box;
}

body {
  padding-bottom: 30px;
  padding-top: 30px;
}

.kalkulator {
  max-width: 500px;
  margin: 0 auto;
  border: 2px solid #111;
  border-radius: 5px;
  background: #333333;
}

.kalkulator-knapper {
  padding: 20px;
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  grid-gap: 3px;
}

.display {
  background: dimgray;
  color: white;
  padding: 10px;
  width: 100%;
  border: 1px solid #111;
  text-align: center;
  font-size: 40px;
  border-radius: 0;
  height: 70px;
}

.kalkulator-knapp {
  font-size: 30px;
  background: dimgray;
  color: white;
  width: 100px;
  height: 60px;
  border-radius: 5%;
  cursor: pointer;
  border: 1px solid #111;
  text-align: center;
}

.er-lik {
  background: orange;
}

.er-clear {
  background: green;
}

input[type="number"]::-webkit-outer-spin-button,
input[type="number"]::-webkit-inner-spin-button {
  -webkit-appearance: none;
  margin: 0;
}
input[type="number"] {
  -moz-appearance: textfield;
}
</style>
