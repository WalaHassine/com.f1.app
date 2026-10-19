# F1 Console Game (`com.f1.app`)

Java console application that simulates a lightweight Formula 1 game loop:
- select pilot, team, vehicle, track, and weather
- run races and a mini season simulation
- answer quiz questions to earn points
- spend points on vehicle upgrades
- track player statistics over time

---

## Project conception

This project is designed as a **modular, object-oriented F1 simulation** with a clear separation between:
- domain entities (pilot, car, track, race result, season)
- application logic (selection, race simulation, season simulation, stats)
- interaction layer (console menus)

The goal is to keep the core simulation simple while showcasing common software design patterns in a practical game scenario.

---

## Architecture

The codebase is organized by responsibility under `core/`:

```text
core/
  app/        # entry point and wiring
  core/       # domain model (engine, pilot, race, season, team, track, vehicle, weather)
  factory/    # object creation logic
  services/   # business/use-case logic
  progress/   # player progression (economy, profile, unlocks)
  quiz/       # quiz domain and question bank
  state/      # game-state abstractions
  ui/         # console menus and input/output helpers
```

### Layered responsibilities

1. **App layer (`app.App`)**  
   Boots the application, instantiates factories/services/managers, and starts the main menu loop.

2. **UI layer (`ui.*`)**  
   Handles user interaction through menus (`MainMenu`, `PilotMenu`, `TeamMenu`, `VehicleMenu`, etc.) and delegates work to services.

3. **Service layer (`services.*`)**  
   Encapsulates game use cases:
   - `SelectionService`: selection of pilot/team/vehicle/track/weather
   - `RaceService`: race outcome calculation
   - `SeasonService`: multi-race season simulation
   - `StatsService`: statistics rendering

4. **Domain layer (`core.*`)**  
   Core entities and value objects such as `Vehicle`, `Engine`, `Team`, `Track`, `Season`, `RaceResult`, and `Stats`.

5. **Progression layer (`progress.*`)**  
   Player profile and points economy (`PlayerProfile`, `EconomyManager`), plus unlock-related abstractions.

6. **Construction layer (`factory.*`)**  
   Centralizes creation logic for domain objects and avoids scattering instantiation details.

---

## Runtime flow

1. `App.main` initializes profile, economy, factories, services, and menus.
2. `MainMenu` runs the primary interaction loop.
3. User actions trigger service calls (selection, race, quiz, season).
4. Services update `PlayerProfile`, `Stats`, and `EconomyManager`.
5. Vehicle upgrades can be stacked before race execution.

---

## Design patterns used

### 1) Singleton
- **Class:** `progress.EconomyManager`
- **Why:** one shared economy/points state across the whole app.
- **How:** private constructor + static `getInstance()`.

### 2) Factory (simple/abstract-factory style)
- **Classes:** `PilotFactory`, `TeamFactory`, `VehicleFactory`, `EngineFactory`, `TrackFactory`, `WeatherFactory`, `SeasonFactory`
- **Why:** centralize creation rules and keep menus/services focused on behavior, not construction details.

### 3) Decorator
- **Classes:** `VehicleDecorator`, `AeroKit`, `EngineUpgrade`, `TyrePackage`
- **Why:** dynamically add vehicle capabilities (speed/handling bonuses) without changing base `Vehicle` class.
- **Usage:** `VehicleMenu` wraps the current vehicle with one or more decorators as upgrades are purchased.

### 4) State
- **Classes:** `GameState`, `MenuState`, `SelectionState`, `RaceState`, `QuizState`, `LockedState`
- **Why:** represent game modes as explicit state objects with `enter/handle/exit` lifecycle methods.
- **Usage:** state objects define behavior per mode and keep transitions explicit.

---

## Build and run

> The repository currently uses plain Java source files (no Maven/Gradle wrapper).

### Prerequisites
- JDK 17+ (recommended)

### Compile
From the repository root:

```bash
javac -d bin $(find core -name "*.java")
```

### Run

```bash
java -cp bin app.App
```

---

## Current feature set

- Player profile and persistent in-session stats
- Team/vehicle/track/weather selection
- Race simulation with randomized component
- Season simulation over a predefined calendar
- Quiz system with reward points
- Vehicle upgrades with stacking decorators
- Basic unlock framework placeholders

---

## Extension ideas

- Save/load profile progression between sessions
- Richer race model (weather, tyre strategy, reliability events)
- Expanded unlock catalog tied to real game content
- Better dependency injection in services/state components
- Automated tests for services and factories

