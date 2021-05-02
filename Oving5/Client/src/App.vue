<template>
  <div class="app" id="app">
    <Kalkulator @legg-til-logg="oppdaterLogg"/>
    <div class="logg">
      <div>
      <h1 id="logg-overskrift">Logg:</h1>
      </div>
      <div class="knapp">
      <button id="knapp" @click="resetLogg">Fjern logg</button>
      </div>
      <ul>
        <li class="logg-objekter" v-for="(loggInfo, index) in logg" :key="index">
          {{loggInfo}}
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
import Kalkulator from './components/Kalkulator.vue'

export default {
  name: 'App',
  components: {
    Kalkulator
  },
    data() {
      return {
        logg: []
      }
    },
    methods: {
      oppdaterLogg(loggInfo) {
        this.logg.push(loggInfo);
      },
      resetLogg() {
        this.logg = [];
      }
    }
}
</script>

<style>
.app {
  display:grid;
  grid-template-columns: 1fr 1fr;
}

.logg{
    background:dimgray;
    border:2px solid black;
    border-radius:5%;
    overflow-x: hidden;
    overflow-y: auto;
    max-height:auto;
    color:white;

}

.logg-objekter{
  font-size:20px;
  text-align:justify;
}
#knapp {
  background: #333333;
  color:white;
  border-radius:5px;
  cursor:pointer;
  font-size:15px;
  margin-top:0px;
}

#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}

#logg-overskrift {
  margin-bottom:0px;
}

ul {
    list-style-type: none;
}


h1 {
  font-size:35px;
}
</style>
