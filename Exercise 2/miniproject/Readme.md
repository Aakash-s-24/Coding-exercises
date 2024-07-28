# Rocket Launch Simulator

Welcome to the **Rocket Launch Simulator** project! This Java application simulates the process of launching a rocket, including pre-launch checks and the launch itself. The application is designed to run continuously, accepting user commands to control the simulation.

## Design Patterns Used

### State Pattern
The State Pattern is employed to manage the different stages of the rocket launch process. This pattern allows the rocket to alter its behavior when its state changes. The key states include:
- **Pre-Launch State**: Handles pre-launch checks and preparations.
- **Launch State**: Manages the actual launch process, updating the rocket's status as it progresses.

*Note: The State Pattern ensures a clear separation of concerns and makes the system easier to maintain and extend.*

## Files Overview

- **RocketState.java**: Interface defining the methods for different rocket states.
- **PreLaunchState.java**: Implements the `RocketState` interface for the pre-launch phase.
- **LaunchState.java**: Implements the `RocketState` interface for the launch phase.
- **RocketLaunchSimulator.java**: The main class that initializes the simulation, handles user inputs, and transitions between different states.

## Getting Started

To compile and run the application, follow these steps:

1. **Clone the Repository**:
   ```sh
   git clone https://github.com/Aakash-s-24/rocket-launch-simulator.git
   cd rocket-launch-simulator
