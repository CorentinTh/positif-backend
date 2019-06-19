import {Consultation, ConsultationState} from "../../app/_models";
import {clients} from "./clients";
import {employees} from "./employees";
import {mediums} from "./mediums";

const randomClient = () => clients[Math.floor(Math.random() * clients.length)];
const randomEmployee = () => employees[Math.floor(Math.random() * employees.length)];
const randomMedium = () => mediums[Math.floor(Math.random() * mediums.length)];

const meClient = clients.find(x => x.lastname === 'Thomasset');
const meEmployee = employees.find(x => x.lastname === 'Thomasset');

const consultations: Consultation[] = [
  {
    id:98754,
    client: meClient,
    employee: meEmployee,
    medium: randomMedium(),
    state : ConsultationState.CLOSED,
    createdAt: new Date(),
    closedAt: new Date(),
    answeredAt: new Date(),
  },
  {
    id:9854,
    client: meClient,
    employee: meEmployee,
    medium: randomMedium(),
    state : ConsultationState.PENDING,
    createdAt: new Date(),
    answeredAt: new Date(),
  },
  {
    id:78554,
    client: meClient,
    employee: meEmployee,
    medium: randomMedium(),
    state : ConsultationState.WAITING_VALIDATION,
    createdAt: new Date(),
  },
  {
    client: randomClient(),
    employee: randomEmployee(),
    medium: randomMedium(),
    state : ConsultationState.CLOSED,
    createdAt: new Date(),
    closedAt: new Date(),
    answeredAt: new Date(),
  },
  {
    client: randomClient(),
    employee: randomEmployee(),
    medium: randomMedium(),
    state : ConsultationState.CLOSED,
    createdAt: new Date(),
    closedAt: new Date(),
    answeredAt: new Date(),
  },
  {
    client: randomClient(),
    employee: randomEmployee(),
    medium: randomMedium(),
    state : ConsultationState.CLOSED,
    createdAt: new Date(),
    closedAt: new Date(),
    answeredAt: new Date(),
  },
  {
    client: randomClient(),
    employee: randomEmployee(),
    medium: randomMedium(),
    state : ConsultationState.CLOSED,
    createdAt: new Date(),
    closedAt: new Date(),
    answeredAt: new Date(),
  }
];

export {consultations};
