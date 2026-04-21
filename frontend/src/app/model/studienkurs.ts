import { Tutor } from "./tutor";

export interface Studienkurs {
    id: number;
    name: string;
    kuerzel: string;
    tutor: Tutor;
}
