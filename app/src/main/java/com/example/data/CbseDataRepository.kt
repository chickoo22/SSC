package com.example.data

object CbseDataRepository {

    val subjects = listOf(
        Subject(
            id = "math",
            name = "Mathematics (Standard/Basic)",
            code = "Code 041 / 241",
            iconName = "calculate",
            totalChapters = 14,
            description = "Complete NCERT syllabus, important theorems, proofs, and solved board papers.",
            chapters = listOf(
                Chapter(
                    id = "math_1",
                    chapterNumber = 1,
                    title = "Real Numbers",
                    weightage = "6 Marks",
                    summary = "Fundamental Theorem of Arithmetic, revisiting rational and irrational numbers.",
                    importantFormulas = listOf("HCF × LCM = Product of two numbers", "√p is irrational for any prime p"),
                    keyQuestions = listOf("Prove that √5 is irrational.", "Find HCF and LCM of 336 and 54 by prime factorization.")
                ),
                Chapter(
                    id = "math_2",
                    chapterNumber = 2,
                    title = "Polynomials",
                    weightage = "4 Marks",
                    summary = "Geometrical meaning of zeroes of a polynomial, relationship between zeroes and coefficients.",
                    importantFormulas = listOf("Sum of zeroes = -b/a", "Product of zeroes = c/a", "Quadratic polynomial: x² - (sum)x + product"),
                    keyQuestions = listOf("Find zeroes of 6x² - 3 - 7x and verify the relationship.", "Find a quadratic polynomial with given sum and product of zeroes.")
                ),
                Chapter(
                    id = "math_3",
                    chapterNumber = 3,
                    title = "Pair of Linear Equations in Two Variables",
                    weightage = "6 Marks",
                    summary = "Graphical method of solution, algebraic methods: Substitution, Elimination.",
                    importantFormulas = listOf("Consistent: a1/a2 ≠ b1/b2 (Unique) or coincident (Infinitely many)", "Inconsistent: a1/a2 = b1/b2 ≠ c1/c2 (Parallel)"),
                    keyQuestions = listOf("Solve graphically: x - y + 1 = 0 and 3x + 2y - 12 = 0.", "The sum of a two-digit number and the number obtained by reversing the digits is 66.")
                ),
                Chapter(
                    id = "math_4",
                    chapterNumber = 4,
                    title = "Quadratic Equations",
                    weightage = "7 Marks",
                    summary = "Standard form ax² + bx + c = 0, solution by factorization and quadratic formula.",
                    importantFormulas = listOf("Discriminant D = b² - 4ac", "Roots = (-b ± √D) / 2a"),
                    keyQuestions = listOf("Find roots of 2x² - x + 1/8 = 0.", "A train travels 360 km at a uniform speed. If the speed had been 5 km/h more, it would have taken 1 hour less.")
                ),
                Chapter(
                    id = "math_5",
                    chapterNumber = 5,
                    title = "Arithmetic Progressions",
                    weightage = "5 Marks",
                    summary = "AP definition, nth term of an AP, sum of first n terms of an AP.",
                    importantFormulas = listOf("an = a + (n - 1)d", "Sn = n/2 [2a + (n - 1)d] = n/2 (a + l)"),
                    keyQuestions = listOf("Find the 11th term of the AP: -3, -1/2, 2, ...", "Find the sum of first 22 terms of an AP in which d = 7 and 22nd term is 149.")
                ),
                Chapter(
                    id = "math_6",
                    chapterNumber = 6,
                    title = "Triangles",
                    weightage = "8 Marks",
                    summary = "Similar figures, similarity of triangles, criteria for similarity (AAA, SSS, SAS), Thales Theorem.",
                    importantFormulas = listOf("Basic Proportionality Theorem (BPT): If a line is drawn parallel to one side of a triangle...", "Ratio of areas of two similar triangles is equal to the square of the ratio of their corresponding sides."),
                    keyQuestions = listOf("State and prove Basic Proportionality Theorem (Thales Theorem).", "Diagonals of a trapezium ABCD intersect each other at the point O. Show that AO/BO = CO/DO.")
                ),
                Chapter(
                    id = "math_7",
                    chapterNumber = 7,
                    title = "Coordinate Geometry",
                    weightage = "6 Marks",
                    summary = "Distance formula, section formula, area of a triangle.",
                    importantFormulas = listOf("Distance = √((x2-x1)² + (y2-y1)²)", "Section formula = ((m1x2+m2x1)/(m1+m2), (m1y2+m2y1)/(m1+m2))"),
                    keyQuestions = listOf("Find the coordinates of the point which divides the join of (-1,7) and (4,-3) in the ratio 2:3.", "Find the relation between x and y such that the point (x,y) is equidistant from (7,1) and (3,5).")
                ),
                Chapter(
                    id = "math_8",
                    chapterNumber = 8,
                    title = "Introduction to Trigonometry",
                    weightage = "7 Marks",
                    summary = "Trigonometric ratios, values of trig ratios for specific angles (0°, 30°, 45°, 60°, 90°), identities.",
                    importantFormulas = listOf("sin²θ + cos²θ = 1", "1 + tan²θ = sec²θ", "1 + cot²θ = cosec²θ"),
                    keyQuestions = listOf("Prove that (sin θ - 2 sin³θ) / (2 cos³θ - cos θ) = tan θ.", "Evaluate: (5 cos² 60° + 4 sec² 30° - tan² 45°) / (sin² 30° + cos² 30°).")
                )
            )
        ),
        Subject(
            id = "science",
            name = "Science (Physics, Chemistry, Bio)",
            code = "Code 086",
            iconName = "science",
            totalChapters = 13,
            description = "Chemical reactions, electricity, light reflection/refraction, life processes, and heredity.",
            chapters = listOf(
                Chapter(
                    id = "sci_1",
                    chapterNumber = 1,
                    title = "Chemical Reactions and Equations",
                    weightage = "6 Marks",
                    summary = "Writing chemical equations, balancing chemical equations, types of chemical reactions (combination, decomposition, displacement, double displacement, oxidation and reduction).",
                    importantFormulas = listOf("Balancing mass conservation", "Rancidity and corrosion prevention"),
                    keyQuestions = listOf("Why should a magnesium ribbon be cleaned before burning in air?", "Balance the equation: HNO3 + Ca(OH)2 → Ca(NO3)2 + H2O.")
                ),
                Chapter(
                    id = "sci_2",
                    chapterNumber = 2,
                    title = "Acids, Bases and Salts",
                    weightage = "6 Marks",
                    summary = "Understanding chemical properties of acids and bases, pH scale, important chemical compounds like Baking soda, Washing soda, Plaster of Paris.",
                    importantFormulas = listOf("pH = -log[H+]", "Plaster of Paris: CaSO4·½H2O"),
                    keyQuestions = listOf("What is a neutralization reaction? Give two examples.", "Write the chemical formula and two uses of Baking Soda.")
                ),
                Chapter(
                    id = "sci_3",
                    chapterNumber = 3,
                    title = "Life Processes",
                    weightage = "7 Marks",
                    summary = "What are life processes? Nutrition, respiration, transportation in human beings and plants, excretion.",
                    importantFormulas = listOf("Aerobic respiration: Glucose + O2 → CO2 + H2O + Energy"),
                    keyQuestions = listOf("Describe the double circulation in human beings. Why is it necessary?", "Explain the mechanism of stomatal opening and closing.")
                ),
                Chapter(
                    id = "sci_4",
                    chapterNumber = 4,
                    title = "Light – Reflection and Refraction",
                    weightage = "7 Marks",
                    summary = "Reflection of light by spherical mirrors, refraction of light, refractive index, lens formula.",
                    importantFormulas = listOf("Mirror formula: 1/f = 1/v + 1/u", "Lens formula: 1/f = 1/v - 1/u", "Magnification m = h'/h = -v/u (mirrors) or v/u (lenses)"),
                    keyQuestions = listOf("Define refractive index of a medium. Light enters from air to glass having refractive index 1.50. What is the speed of light in glass?", "A concave mirror has a focal length of 15 cm. At what distance should an object be placed...")
                ),
                Chapter(
                    id = "sci_5",
                    chapterNumber = 5,
                    title = "Electricity",
                    weightage = "7 Marks",
                    summary = "Electric current and circuit, electric potential and potential difference, Ohm's law, resistance factors, heating effect.",
                    importantFormulas = listOf("V = IR", "Power P = VI = I²R = V²/R", "Energy E = P × t", "Series: R = R1 + R2 + ...", "Parallel: 1/R = 1/R1 + 1/R2 + ..."),
                    keyQuestions = listOf("State Ohm's law. Draw a circuit diagram for verifying Ohm's law.", "An electric iron consumes energy at a rate of 840 W when heating is at the maximum rate and 360 W when the heating is at the minimum.")
                )
            )
        ),
        Subject(
            id = "sst",
            name = "Social Science (History, Geo, Civics, Eco)",
            code = "Code 087",
            iconName = "public",
            totalChapters = 20,
            description = "Rise of nationalism, resources & development, federalism, gender religion & caste, and globalization.",
            chapters = listOf(
                Chapter(
                    id = "sst_1",
                    chapterNumber = 1,
                    title = "Rise of Nationalism in Europe",
                    weightage = "5 Marks",
                    summary = "French Revolution, the age of revolutions (1830-1848), unification of Germany and Italy, visualising the nation.",
                    importantFormulas = listOf(),
                    keyQuestions = listOf("Explain the role of Mazzini, Cavour and Garibaldi in the unification of Italy.", "Write a note on the Greek War of Independence.")
                ),
                Chapter(
                    id = "sst_2",
                    chapterNumber = 2,
                    title = "Resources and Development",
                    weightage = "4 Marks",
                    summary = "Classification of resources, development of resources, resource planning in India, land resources and utilization.",
                    importantFormulas = listOf(),
                    keyQuestions = listOf("Distinguish between renewable and non-renewable resources.", "Explain why resource planning is essential in India.")
                ),
                Chapter(
                    id = "sst_3",
                    chapterNumber = 3,
                    title = "Power Sharing",
                    weightage = "4 Marks",
                    summary = "Case studies of Belgium and Sri Lanka, why power sharing is desirable, forms of power sharing.",
                    importantFormulas = listOf(),
                    keyQuestions = listOf("Explain the majoritarian measures taken in Sri Lanka to establish Sinhala supremacy.", "What are the different forms of power sharing in modern democracies?")
                ),
                Chapter(
                    id = "sst_4",
                    chapterNumber = 4,
                    title = "Development (Economics)",
                    weightage = "4 Marks",
                    summary = "What Development Promises, income and other goals, national development, how to compare different countries or states, public facilities, sustainability of development.",
                    importantFormulas = listOf(),
                    keyQuestions = listOf("Why is Per Capita Income calculated in US dollars?", "What is Sustainable Development? Suggest ways to achieve it.")
                )
            )
        ),
        Subject(
            id = "english",
            name = "English (Language & Literature)",
            code = "Code 184",
            iconName = "menu_book",
            totalChapters = 15,
            description = "Reading comprehension, writing skills (letters, analytical paragraphs), grammar, and literature (First Flight & Footprints without Feet).",
            chapters = listOf(
                Chapter(
                    id = "eng_1",
                    chapterNumber = 1,
                    title = "A Letter to God",
                    weightage = "Reading & Lit",
                    summary = "Lencho's unshakable faith in God after a devastating hailstorm destroys his corn crop.",
                    importantFormulas = listOf(),
                    keyQuestions = listOf("Why did Lencho write a letter to God?", "Who does Lencho have complete faith in? Which sentences in the story tell you this?")
                ),
                Chapter(
                    id = "eng_2",
                    chapterNumber = 2,
                    title = "Nelson Mandela: Long Walk to Freedom",
                    weightage = "Reading & Lit",
                    summary = "Excerpts from Mandela's autobiography detailing the historic inauguration and struggle against apartheid.",
                    importantFormulas = listOf(),
                    keyQuestions = listOf("What 'twin obligations' does Mandela mention?", "Why did the inauguration ceremony take place in the amphitheater formed by the Union buildings in Pretoria?")
                )
            )
        )
    )

    val pastPapers = listOf(
        PastPaper(
            id = "paper_2025_math",
            year = "2025",
            subject = "Mathematics Standard",
            title = "CBSE Class 10 Board Exam Official Paper 2025",
            type = PaperType.SOLVED_BOARD_PAPER,
            totalMarks = 80,
            durationHours = "3 Hours",
            sections = listOf(
                PaperSection("Section A: Multiple Choice Questions (Q1-Q20)", 1, 20, listOf(
                    "Q1: If two positive integers a and b are written as a = x³y² and b = xy³, where x, y are prime numbers, then HCF(a,b) is...",
                    "Q2: The discriminant of the quadratic equation 2x² - 4x + 3 = 0 is...",
                    "Q3: If the sum of the zeroes of the quadratic polynomial kx² - 3x + 5 is 1, then the value of k is..."
                )),
                PaperSection("Section B: Very Short Answer Type (Q21-Q25)", 2, 5, listOf(
                    "Q21: Prove that the tangents drawn at the ends of a diameter of a circle are parallel.",
                    "Q22: Find the value(s) of k for which the quadratic equation 2x² + kx + 3 = 0 has real and equal roots."
                )),
                PaperSection("Section C: Short Answer Type (Q26-Q31)", 3, 6, listOf(
                    "Q26: Prove that √3 is an irrational number.",
                    "Q27: Find the zeroes of the quadratic polynomial 4x² - 4x - 3 and verify the relationship between zeroes and coefficients."
                )),
                PaperSection("Section D: Long Answer Type (Q32-Q35)", 5, 4, listOf(
                    "Q32: State and prove Pythagoras Theorem.",
                    "Q33: A motor boat whose speed is 18 km/h in still water takes 1 hour more to go 24 km upstream than to return downstream to the same spot."
                ))
            )
        ),
        PastPaper(
            id = "paper_2024_science",
            year = "2024",
            subject = "Science",
            title = "CBSE Class 10 Board Exam Official Paper 2024",
            type = PaperType.SOLVED_BOARD_PAPER,
            totalMarks = 80,
            durationHours = "3 Hours",
            sections = listOf(
                PaperSection("Section A: Physics, Chemistry, Biology MCQs (Q1-Q20)", 1, 20, listOf(
                    "Q1: Which of the following observation helps us to determine that a chemical reaction has taken place?",
                    "Q2: An object is placed at a distance of 10 cm in front of a convex mirror of focal length 15 cm. Find the position of the image."
                )),
                PaperSection("Section B: Short Answers (Q21-Q26)", 2, 6, listOf(
                    "Q21: Why is respiration considered an exothermic reaction? Explain.",
                    "Q22: State two reasons for adopting contraceptive methods."
                ))
            )
        ),
        PastPaper(
            id = "paper_2025_sample_math",
            year = "2025 (Sample)",
            subject = "Mathematics Standard",
            title = "CBSE Official Sample Question Paper 2025-26 with Marking Scheme",
            type = PaperType.SAMPLE_PAPER,
            totalMarks = 80,
            durationHours = "3 Hours",
            sections = listOf(
                PaperSection("Section A (MCQs 1-20)", 1, 20, listOf(
                    "Sample Q1: If HCF(16, y) = 8 and LCM(16, y) = 48, then the value of y is...",
                    "Sample Q2: The pair of equations x + 2y + 5 = 0 and -3x - 6y + 1 = 0 has..."
                ))
            )
        )
    )

    val studyTips = listOf(
        StudyTip(
            title = "Master NCERT First",
            tip = "CBSE board exams are 90% based on NCERT textbooks. Read every example, in-text question, and back-of-chapter exercise thoroughly.",
            category = "Strategy"
        ),
        StudyTip(
            title = "Solve Last 5 Years Papers",
            tip = "Practicing past board papers under timed 3-hour conditions builds examination stamina and reveals recurring question patterns.",
            category = "Practice"
        ),
        StudyTip(
            title = "Make Formula Flashcards",
            tip = "Create short formula sheets for Mathematics and Physics chapters and revise them every morning before starting study sessions.",
            category = "Revision"
        ),
        StudyTip(
            title = "Present Answers Neatly",
            tip = "In board exams, underline key terms, write final answers with units, and draw clean diagrams with sharp pencils for maximum marks.",
            category = "Exam Tips"
        )
    )
}
