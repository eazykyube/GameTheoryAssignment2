# Moose-life

Implementation of an assignment which was done within Game Theory course of Innopolis University.

## Problem Statement
Moose are large quadrupedal herbivores which range in Northern longitudes from the Northern United
States, Canada, Scandinavia, and Russia. They are territorial in nature and it is known for Bull Moose to
fight when encountering each other. In this simulation, we will create a model of the environment in
order to understand the nature of these creatures.
## Problem Definition
The environment in which they live is three territorial regions which we will helpfully entitle as A, B, and
C fields. In these fields, various vegetation grows in a sigmoid fashion given by equation f(X) = (10 * e^x) / (1 + e^x). You may assume that these fields start with X=1, i.e. f(1). If a Moose is not present in the square, then
the field increases X by 1. If a Moose is in the field, or if two Moose are in the field, then the field’s X is
decreased by 1, to a minimum of 0.
Moose receive the following payouts. If there is only a single Moose in the field k, then he eats the
vegetation based on the amount available and gains fk(Xk) - f(0). If both of the Moose are in the
same field, then they will fight. Fighting is exhausting and prevents eating and damages the local area,
and causes of a score of 0 to be given to both Moose.
## Task
You will create an agent for the Moose, and test your Moose agent against others. Your code will need
to be written in Java, and you will create your inherited agent via the interface as seen below. The
interface has a void method reset() which will be called in order to ‘reset’ the agent for a round of play,
and an integer method move() returning the move which is given the last opponent move (0 – if this is
the first move), and the current X values for the three fields. The move() method returns 1 for A, 2 for B
and 3 for C fields. Also, the interface has a getEmail() method returning String with your Innopolis email.
You will have to test your agent(s) via a tournament method.
