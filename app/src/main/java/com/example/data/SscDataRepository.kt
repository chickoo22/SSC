package com.example.data

object SscDataRepository {

    val subjects = listOf(
        Subject(
            id = "math_1",
            name = "Mathematics Part - I (Algebra)",
            code = "Code 71",
            iconName = "calculate",
            totalChapters = 6,
            description = "Linear equations in two variables, Quadratic equations, Arithmetic progression, Financial planning, Probability, Statistics.",
            chapters = listOf(
                Chapter(
                    id = "m1_c1",
                    chapterNumber = 1,
                    title = "Linear Equations in Two Variables",
                    weightage = "12 Marks",
                    summary = "Solving simultaneous linear equations by elimination method, Cramer's rule using determinants, equations reducible to linear equations.",
                    importantFormulas = listOf("Determinant value: ad - bc", "Cramer's Rule: x = Dx/D, y = Dy/D"),
                    keyQuestions = listOf("Solve by Cramer's rule: 3x - 4y = 10, 4x + 3y = 5.", "A two-digit number is 4 times the sum of its digits...")
                ),
                Chapter(
                    id = "m1_c2",
                    chapterNumber = 2,
                    title = "Quadratic Equations",
                    weightage = "12 Marks",
                    summary = "Standard form ax² + bx + c = 0, solution by factorization and formula method, relation between roots and coefficients.",
                    importantFormulas = listOf("Discriminant Δ = b² - 4ac", "Roots = (-b ± √Δ) / 2a", "Sum of roots = -b/a, Product = c/a"),
                    keyQuestions = listOf("Solve using formula: m² - 14m + 13 = 0.", "Find quadratic equation whose roots are 3 and -4.")
                ),
                Chapter(
                    id = "m1_c3",
                    chapterNumber = 3,
                    title = "Arithmetic Progression",
                    weightage = "8 Marks",
                    summary = "Sequence, Arithmetic Progression (AP), nth term of an AP, sum of first n terms of an AP.",
                    importantFormulas = listOf("tn = a + (n - 1)d", "Sn = (n/2)[2a + (n - 1)d]"),
                    keyQuestions = listOf("Find 19th term of the AP: 7, 13, 19, 25, ...", "Find the sum of all even numbers between 1 and 100.")
                ),
                Chapter(
                    id = "m1_c4",
                    chapterNumber = 4,
                    title = "Financial Planning",
                    weightage = "8 Marks",
                    summary = "GST (Goods and Services Tax), computation of ITC, shares, mutual funds, SIP.",
                    importantFormulas = listOf("GST = CGST + SGST", "Brokerage = % of Share Value"),
                    keyQuestions = listOf("A trader in Mumbai sold goods worth ₹ 10,000 to a customer in Nagpur. Rate of GST is 12%. Find CGST and SGST.")
                ),
                Chapter(
                    id = "m1_c5",
                    chapterNumber = 5,
                    title = "Probability",
                    weightage = "8 Marks",
                    summary = "Random experiment, sample space, event, probability of an event using sample space.",
                    importantFormulas = listOf("P(A) = n(A) / n(S)", "0 ≤ P(A) ≤ 1", "P(A') = 1 - P(A)"),
                    keyQuestions = listOf("Two dice are thrown simultaneously. Find probability that sum of numbers on upper faces is a prime number.")
                ),
                Chapter(
                    id = "m1_c6",
                    chapterNumber = 6,
                    title = "Statistics",
                    weightage = "12 Marks",
                    summary = "Mean, median, mode of grouped data, frequency polygon, pie diagram, histogram.",
                    importantFormulas = listOf("Mean (Assumed mean method) = A + (Σfi di / Σfi)", "Mode = l + [(f1 - f0)/(2f1 - f0 - f2)] × h"),
                    keyQuestions = listOf("Find the median of the following frequency distribution table...", "Draw a frequency polygon for the given data.")
                )
            )
        ),
        Subject(
            id = "math_2",
            name = "Mathematics Part - II (Geometry)",
            code = "Code 72",
            iconName = "shapes",
            totalChapters = 7,
            description = "Similarity, Pythagoras theorem, Circle, Coordinate geometry, Trigonometry, Mensuration.",
            chapters = listOf(
                Chapter(
                    id = "m2_c1",
                    chapterNumber = 1,
                    title = "Similarity",
                    weightage = "10 Marks",
                    summary = "Ratio of areas of two triangles, Basic Proportionality theorem, tests of similarity (AA, SSS, SAS).",
                    importantFormulas = listOf("Area of triangle ∝ base × height", "BPT Theorem ratio equality"),
                    keyQuestions = listOf("State and prove Basic Proportionality Theorem.", "In ΔABC, ray BD bisects ∠ABC. If AB = x, BC = x+2, AD = x-2, DC = x+1, find x.")
                ),
                Chapter(
                    id = "m2_c2",
                    chapterNumber = 2,
                    title = "Pythagoras Theorem",
                    weightage = "7 Marks",
                    summary = "Similar right-angled triangles, geometric mean theorem, Pythagoras theorem, converse of Pythagoras theorem, Appollonius theorem.",
                    importantFormulas = listOf("In right angled Δ, altitude on hypotenuse is geometric mean of segments", "AB² + AC² = 2AM² + 2BM² (Apollonius)"),
                    keyQuestions = listOf("Prove Pythagoras Theorem.", "Find length of diagonal of a rectangle whose length is 35 cm and breadth is 12 cm.")
                ),
                Chapter(
                    id = "m2_c3",
                    chapterNumber = 3,
                    title = "Circle",
                    weightage = "12 Marks",
                    summary = "Tangent theorem, tangent segment theorem, cyclic quadrilateral, secant and tangent angle theorem.",
                    importantFormulas = listOf("Tangent is perpendicular to radius at point of contact", "Opposite angles of cyclic quadrilateral are supplementary"),
                    keyQuestions = listOf("Prove that tangent segments drawn from an external point to a circle are congruent.", "If radii of two circles are 5.5 cm and 4.2 cm, find distance between their centers for touching externally.")
                ),
                Chapter(
                    id = "m2_c4",
                    chapterNumber = 4,
                    title = "Geometric Constructions",
                    weightage = "7 Marks",
                    summary = "Constructing similar triangles, tangent to a circle at a point on the circle, tangent from external point.",
                    importantFormulas = listOf(),
                    keyQuestions = listOf("Draw a circle of radius 3.3 cm. Take a point P on it and draw tangent to the circle at P without using center.")
                ),
                Chapter(
                    id = "m2_c5",
                    chapterNumber = 5,
                    title = "Coordinate Geometry",
                    weightage = "7 Marks",
                    summary = "Distance formula, section formula, midpoint formula, slope of a line.",
                    importantFormulas = listOf("Distance = √((x2-x1)² + (y2-y1)²)", "Slope m = (y2-y1)/(x2-x1)"),
                    keyQuestions = listOf("Find coordinates of point dividing line segment joining ((-1,7) and (4,-3) in ratio 2:3.", "Show that points A(1,-2), B(3,2), C(-3,-4) are vertices of a right-angled triangle.")
                ),
                Chapter(
                    id = "m2_c6",
                    chapterNumber = 6,
                    title = "Trigonometry",
                    weightage = "7 Marks",
                    summary = "Trigonometric ratios, trigonometric identities, applications in height and distances.",
                    importantFormulas = listOf("sin²θ + cos²θ = 1", "1 + tan²θ = sec²θ", "1 + cot²θ = cosec²θ"),
                    keyQuestions = listOf("Prove: sec θ (1 - sin θ) (sec θ + tan θ) = 1.", "A ladder 10 m long reaches a window 8 m above ground. Find distance of foot of ladder from wall.")
                ),
                Chapter(
                    id = "m2_c7",
                    chapterNumber = 7,
                    title = "Mensuration",
                    weightage = "10 Marks",
                    summary = "Surface area and volume of cone, cylinder, sphere, frustum of a cone.",
                    importantFormulas = listOf("Volume of cone = ⅓πr²h", "Surface area of sphere = 4πr²", "Frustum volume = ⅓πh(r1² + r2² + r1r2)"),
                    keyQuestions = listOf("The radius of base of a cone is 3 cm and height is 4 cm. Find its total surface area and volume.", "A bucket is in form of frustum of a cone...")
                )
            )
        ),
        Subject(
            id = "sci_1",
            name = "Science and Technology Part - I",
            code = "Code 72",
            iconName = "science",
            totalChapters = 10,
            description = "Gravitation, Periodic classification of elements, Chemical reactions, Effects of electric current, Heat, Refraction of light, Lenses, Metallurgy, Carbon compounds, Space missions.",
            chapters = listOf(
                Chapter(
                    id = "s1_c1",
                    chapterNumber = 1,
                    title = "Gravitation",
                    weightage = "5 Marks",
                    summary = "Kepler's laws, Newton's universal law of gravitation, acceleration due to gravity (g), free fall, escape velocity.",
                    importantFormulas = listOf("F = G(m1 m2)/r²", "g = GM/R²", "Escape velocity ve = √(2GM/R)"),
                    keyQuestions = listOf("State Kepler's three laws of planetary motion.", "What is free fall? Why does an object fall with same acceleration irrespective of mass?")
                ),
                Chapter(
                    id = "s1_c2",
                    chapterNumber = 2,
                    title = "Periodic Classification of Elements",
                    weightage = "6 Marks",
                    summary = "Dobereiner's triads, Newlands' law of octaves, Mendeleev's periodic table, Modern periodic table and periodic trends.",
                    importantFormulas = listOf(),
                    keyQuestions = listOf("Explain Mendeleev's periodic law. What are merits and demerits?", "How does atomic radius change down a group and across a period?")
                ),
                Chapter(
                    id = "s1_c3",
                    chapterNumber = 3,
                    title = "Chemical Reactions and Equations",
                    weightage = "6 Marks",
                    summary = "Writing chemical equations, balancing, types of chemical reactions, rate of chemical reaction and factors affecting it.",
                    importantFormulas = listOf(),
                    keyQuestions = listOf("Explain factors affecting rate of chemical reaction with examples.", "Balance: NaOH + H2SO4 → Na2SO4 + H2O.")
                ),
                Chapter(
                    id = "s1_c4",
                    chapterNumber = 4,
                    title = "Effects of Electric Current",
                    weightage = "7 Marks",
                    summary = "Magnetic effect of electric current, Lorentz force, Fleming's left and right hand rules, electric motor, electric generator, domestic electric circuits.",
                    importantFormulas = listOf("Power P = VI = I²R"),
                    keyQuestions = listOf("State Fleming's Right Hand Rule and Left Hand Rule.", "Explain working principle of electric generator with neat diagram.")
                ),
                Chapter(
                    id = "s1_c5",
                    chapterNumber = 5,
                    title = "Heat",
                    weightage = "5 Marks",
                    summary = "Latent heat, regelation, specific heat capacity, calorimeter.",
                    importantFormulas = listOf("Heat gained = Heat lost", "Q = m c ΔT"),
                    keyQuestions = listOf("Explain anomalous behavior of water.", "Define specific heat capacity. State its SI unit.")
                )
            )
        ),
        Subject(
            id = "sci_2",
            name = "Science and Technology Part - II",
            code = "Code 73",
            iconName = "biotech",
            totalChapters = 10,
            description = "Heredity and Evolution, Life processes in living organisms (Part 1 & 2), Environmental management, Animal classification, Introduction to microbiology, Cell biology and biotechnology, Social health, Disaster management.",
            chapters = listOf(
                Chapter(
                    id = "s2_c1",
                    chapterNumber = 1,
                    title = "Heredity and Evolution",
                    weightage = "5 Marks",
                    summary = "Central dogma, transcription, translation, translocation, evolution, evidences of evolution, Darwin's theory, Lamarckism.",
                    importantFormulas = listOf(),
                    keyQuestions = listOf("Explain Central Dogma of protein synthesis.", "Write short note on Darwin's theory of natural selection.")
                ),
                Chapter(
                    id = "s2_c2",
                    chapterNumber = 2,
                    title = "Life Processes in Living Organisms Part - 1",
                    weightage = "6 Marks",
                    summary = "Cellular respiration, glycolysis, TCA cycle, ATP production, energy from different food components, cell division (mitosis and meiosis).",
                    importantFormulas = listOf("Glucose + 6O2 → 6CO2 + 6H2O + Energy (38 ATP)"),
                    keyQuestions = listOf("Explain glycolysis in detail.", "Differentiate between mitosis and meiosis cell division.")
                ),
                Chapter(
                    id = "s2_c3",
                    chapterNumber = 3,
                    title = "Life Processes in Living Organisms Part - 2",
                    weightage = "7 Marks",
                    summary = "Asexual and sexual reproduction in plants and animals, human reproductive system, menstrual cycle, population control.",
                    importantFormulas = listOf(),
                    keyQuestions = listOf("Explain human female reproductive system with diagram.", "What is asexual reproduction in multicellular organisms? Give examples.")
                )
            )
        ),
        Subject(
            id = "sst",
            name = "Social Sciences (History, Pol. Sci, Geography)",
            code = "Code 74",
            iconName = "public",
            totalChapters = 18,
            description = "Historiography, Indian Tradition, Applied History, Mass Media, Political Science (Constitution, Electoral process, Political parties), Geography (Physiography, Climate, Industries, Transport).",
            chapters = listOf(
                Chapter(
                    id = "sst_c1",
                    chapterNumber = 1,
                    title = "Historiography: Development in the West",
                    weightage = "4 Marks",
                    summary = "Tradition of historiography, modern historiography, notable scholars like René Descartes, Voltaire, Leopold von Ranke, Karl Marx.",
                    importantFormulas = listOf(),
                    keyQuestions = listOf("Explain Voltaire's contribution to development of historiography.", "Write note on Marxist historiography.")
                ),
                Chapter(
                    id = "sst_c2",
                    chapterNumber = 2,
                    title = "India's Physiography and Drainage",
                    weightage = "6 Marks",
                    summary = "Location, extent, physiographic divisions of India and Brazil, river systems (Himalayan and Peninsular rivers).",
                    importantFormulas = listOf(),
                    keyQuestions = listOf("Compare physiography of India and Brazil.", "Distinguish between Himalayan rivers and Peninsular rivers.")
                )
            )
        ),
        Subject(
            id = "english",
            name = "English Kumarbharati",
            code = "Code 01",
            iconName = "menu_book",
            totalChapters = 12,
            description = "Prose, Poetry, Writing skills (Letter writing, Report writing, Dialogue writing, Speech writing, Expansion of theme, Summary writing), Grammar.",
            chapters = listOf(
                Chapter(
                    id = "eng_c1",
                    chapterNumber = 1,
                    title = "Where the Mind is Without Fear (Rabindranath Tagore)",
                    weightage = "Poem Appreciation",
                    summary = "Tagore's prayer to God for a truly free, united, truthful, and progressive nation.",
                    importantFormulas = listOf(),
                    keyQuestions = listOf("Appreciate the poem 'Where the Mind is Without Fear' based on title, poet, rhyme scheme, figures of speech, and central idea.", "What qualities does the poet desire in his countrymen?")
                ),
                Chapter(
                    id = "eng_c2",
                    chapterNumber = 2,
                    title = "The Thief's Story (Ruskin Bond)",
                    weightage = "Prose & Grammar",
                    summary = "An honest touch and kindness transforms a teenage thief named Hari Singh.",
                    importantFormulas = listOf(),
                    keyQuestions = listOf("Why did Anil forgive Hari Singh? How did it change Hari's life?", "Do you think friendships can reform people? Justify.")
                )
            )
        )
    )

    val pastPapers = listOf(
        PastPaper(
            id = "paper_2025_m1",
            year = "March 2025",
            subject = "Mathematics Part - I (Algebra)",
            title = "Maharashtra SSC Board Exam Official Paper March 2025 (Solved)",
            type = PaperType.SOLVED_BOARD_PAPER,
            totalMarks = 40,
            durationHours = "2 Hours",
            sections = listOf(
                PaperSection("Q1. (A) Choose correct alternative (4 Marks)", 1, 4, listOf(
                    "Q1(A)1: To solve x + y = 3, 3x - 2y = 4 by determinants, find D...",
                    "Q1(A)2: Out of the following equations, which one is a quadratic equation?"
                )),
                PaperSection("Q1. (B) Solve the following subquestions (4 Marks)", 1, 4, listOf(
                    "Q1(B)1: Find first two terms of AP whose a = 5, d = 3."
                )),
                PaperSection("Q2. (A) Complete the following activities (4 Marks)", 2, 2, listOf(
                    "Q2(A)1: Complete activity to find discriminant of x² + 2x - 5 = 0."
                )),
                PaperSection("Q3. (A) Complete activity (3 Marks)", 3, 1, listOf(
                    "Q3(A)1: Complete activity of solving simultaneous equations by Cramer's rule."
                )),
                PaperSection("Q4. Solve following subquestions (8 Marks)", 4, 4, listOf(
                    "Q4(1): Solve quadratic equation by formula method: 5m² + 13m + 8 = 0."
                )),
                PaperSection("Q5. Solve creative questions (3 Marks)", 3, 2, listOf(
                    "Q5(1): If roots of ax² + bx + c = 0 are equal, show that b² = 4ac."
                ))
            )
        ),
        PastPaper(
            id = "paper_2024_sci1",
            year = "March 2024",
            subject = "Science & Tech Part - I",
            title = "Maharashtra SSC Board Exam Official Paper March 2024 (Solved)",
            type = PaperType.SOLVED_BOARD_PAPER,
            totalMarks = 40,
            durationHours = "2 Hours",
            sections = listOf(
                PaperSection("Q1. Multiple Choice Questions (5 Marks)", 1, 5, listOf(
                    "Q1(A)1: The gravitational force between two bodies is directly proportional to...",
                    "Q1(A)2: In modern periodic table, elements in same group have same number of..."
                )),
                PaperSection("Q2. Answer following (7 Marks)", 2, 7, listOf(
                    "Q2(a): Find odd one out: Dobereiner's triads, Newlands' octaves, Mendeleev's periodic table, Rutherford model."
                ))
            )
        ),
        PastPaper(
            id = "paper_sample_2025",
            year = "2025-26 (Sample)",
            subject = "Mathematics Part - II (Geometry)",
            title = "Maharashtra State Board Official Model Question Paper with Solution",
            type = PaperType.SAMPLE_PAPER,
            totalMarks = 40,
            durationHours = "2 Hours",
            sections = listOf(
                PaperSection("Q1. MCQ & Objective (8 Marks)", 1, 8, listOf(
                    "Sample Q1: Choose correct option for similarity ratio of areas."
                ))
            )
        )
    )

    val studyTips = listOf(
        StudyTip(
            title = "Solve Textbook Exercises & Practice Sets",
            tip = "Maharashtra SSC board papers are heavily based on problems from practice sets and problem sets in Balbharati textbooks.",
            category = "Strategy"
        ),
        StudyTip(
            title = "Board Answer Presentation",
            tip = "For geometry theorems (Pythagoras, BPT), draw neat labeled diagrams with compass and pencil. Write 'Given', 'To Prove', and 'Proof' clearly.",
            category = "Exam Tips"
        ),
        StudyTip(
            title = "Practice Last 5 Years Board Papers",
            tip = "Solve Board question papers of March and July sessions under timed conditions to master time management.",
            category = "Practice"
        ),
        StudyTip(
            title = "Formula Book for Math & Science",
            tip = "Maintain a dedicated formula notebook for Algebra formulas, Geometry theorems, and Science chemical equations.",
            category = "Revision"
        )
    )
}
