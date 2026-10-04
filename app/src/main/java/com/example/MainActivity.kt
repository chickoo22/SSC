package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.*
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.ui.SscViewModel
import com.example.ui.screens.*
import com.example.ui.theme.SscAppTheme
import kotlinx.coroutines.launch
import java.net.URLDecoder
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

class MainActivity : ComponentActivity() {
    private val viewModel: SscViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val isDarkMode by viewModel.isDarkMode.collectAsState()
            SscAppTheme(darkTheme = isDarkMode) {
                MainAppScaffold(viewModel = viewModel)
            }
        }
    }
}

sealed class Screen(val route: String, val title: String, val icon: androidx.compose.ui.graphics.vector.ImageVector) {
    object Home : Screen("home", "Home", Icons.Default.Home)
    object Subjects : Screen("subjects", "Subjects", Icons.AutoMirrored.Filled.MenuBook)
    object Pomodoro : Screen("pomodoro", "Timer", Icons.Default.Timer)
    object Papers : Screen("papers", "Papers", Icons.AutoMirrored.Filled.Assignment)
    object Progress : Screen("progress", "Tracker", Icons.Default.CheckCircle)
    object Detail : Screen("detail/{title}/{subtitle}/{content}", "Detail", Icons.Default.Info) {
        fun createRoute(title: String, subtitle: String, content: String): String {
            val encodedTitle = URLEncoder.encode(title, StandardCharsets.UTF_8.toString())
            val encodedSubtitle = URLEncoder.encode(subtitle, StandardCharsets.UTF_8.toString())
            val encodedContent = URLEncoder.encode(content, StandardCharsets.UTF_8.toString())
            return "detail/$encodedTitle/$encodedSubtitle/$encodedContent"
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainAppScaffold(viewModel: SscViewModel) {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val isDarkMode by viewModel.isDarkMode.collectAsState()

    var showRateDialog by remember { mutableStateOf(false) }
    var showOtherAppsDialog by remember { mutableStateOf(false) }
    var showGuidelinesDialog by remember { mutableStateOf(false) }
    var showAboutDialog by remember { mutableStateOf(false) }

    val items = listOf(
        Screen.Home,
        Screen.Subjects,
        Screen.Pomodoro,
        Screen.Papers,
        Screen.Progress
    )

    val showBottomBar = currentRoute in items.map { it.route }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            AppDrawerContent(
                drawerState = drawerState,
                currentRoute = currentRoute,
                isDarkMode = isDarkMode,
                onNavigate = { route ->
                    scope.launch { drawerState.close() }
                    navController.navigate(route) {
                        popUpTo(navController.graph.findStartDestination().id) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                onToggleDarkMode = { viewModel.toggleDarkMode() },
                onShowGuidelines = { showGuidelinesDialog = true },
                onShowRate = { showRateDialog = true },
                onShowOtherApps = { showOtherAppsDialog = true },
                onShowAbout = { showAboutDialog = true }
            )
        }
    ) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            bottomBar = {
                if (showBottomBar) {
                    NavigationBar(
                        containerColor = MaterialTheme.colorScheme.surface,
                        contentColor = MaterialTheme.colorScheme.primary
                    ) {
                        items.forEach { screen ->
                            NavigationBarItem(
                                icon = { Icon(screen.icon, contentDescription = screen.title) },
                                label = { Text(screen.title) },
                                selected = currentRoute == screen.route,
                                onClick = {
                                    if (currentRoute != screen.route) {
                                        navController.navigate(screen.route) {
                                            popUpTo(navController.graph.findStartDestination().id) {
                                                saveState = true
                                            }
                                            launchSingleTop = true
                                            restoreState = true
                                        }
                                    }
                                },
                                colors = NavigationBarItemDefaults.colors(
                                    selectedIconColor = MaterialTheme.colorScheme.primary,
                                    unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                                    selectedTextColor = MaterialTheme.colorScheme.primary,
                                    unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
                                    indicatorColor = MaterialTheme.colorScheme.primaryContainer
                                )
                            )
                        }
                    }
                }
            }
        ) { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = Screen.Home.route,
                modifier = Modifier.padding(innerPadding)
            ) {
                composable(Screen.Home.route) {
                    HomeScreen(
                        viewModel = viewModel,
                        onNavigateToSubjects = { navController.navigate(Screen.Subjects.route) },
                        onNavigateToPapers = { navController.navigate(Screen.Papers.route) },
                        onNavigateToDetail = { title, subtitle, content ->
                            navController.navigate(Screen.Detail.createRoute(title, subtitle, content))
                        },
                        onOpenDrawer = { scope.launch { drawerState.open() } }
                    )
                }
                composable(Screen.Subjects.route) {
                    SubjectsScreen(
                        viewModel = viewModel,
                        onNavigateToDetail = { title, subtitle, content ->
                            navController.navigate(Screen.Detail.createRoute(title, subtitle, content))
                        },
                        onOpenDrawer = { scope.launch { drawerState.open() } }
                    )
                }
                composable(Screen.Pomodoro.route) {
                    PomodoroScreen(
                        viewModel = viewModel,
                        onOpenDrawer = { scope.launch { drawerState.open() } }
                    )
                }
                composable(Screen.Papers.route) {
                    PastPapersScreen(
                        viewModel = viewModel,
                        onNavigateToDetail = { title, subtitle, content ->
                            navController.navigate(Screen.Detail.createRoute(title, subtitle, content))
                        },
                        onOpenDrawer = { scope.launch { drawerState.open() } }
                    )
                }
                composable(Screen.Progress.route) {
                    ProgressDashboardScreen(
                        viewModel = viewModel,
                        onOpenDrawer = { scope.launch { drawerState.open() } }
                    )
                }
                composable(
                    route = Screen.Detail.route,
                    arguments = listOf(
                        navArgument("title") { type = NavType.StringType },
                        navArgument("subtitle") { type = NavType.StringType },
                        navArgument("content") { type = NavType.StringType }
                    )
                ) { backStackEntry ->
                    val encodedTitle = backStackEntry.arguments?.getString("title") ?: ""
                    val encodedSubtitle = backStackEntry.arguments?.getString("subtitle") ?: ""
                    val encodedContent = backStackEntry.arguments?.getString("content") ?: ""

                    val title = URLDecoder.decode(encodedTitle, StandardCharsets.UTF_8.toString())
                    val subtitle = URLDecoder.decode(encodedSubtitle, StandardCharsets.UTF_8.toString())
                    val content = URLDecoder.decode(encodedContent, StandardCharsets.UTF_8.toString())

                    DetailScreen(
                        title = title,
                        subtitle = subtitle,
                        content = content,
                        onBack = { navController.popBackStack() }
                    )
                }
            }
        }
    }

    if (showRateDialog) {
        AlertDialog(
            onDismissRequest = { showRateDialog = false },
            title = { Text("Rate Maharashtra SSC Hub") },
            text = { Text("If you find this app helpful for your SSC Std 10 Board exams, please give us a 5-star rating on the Play Store!") },
            confirmButton = {
                TextButton(onClick = { showRateDialog = false }) {
                    Text("Rate 5 Stars ⭐")
                }
            },
            dismissButton = {
                TextButton(onClick = { showRateDialog = false }) {
                    Text("Later")
                }
            }
        )
    }

    if (showOtherAppsDialog) {
        AlertDialog(
            onDismissRequest = { showOtherAppsDialog = false },
            title = { Text("Other Educational Apps") },
            text = {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text("• Maharashtra HSC 12th Hub")
                    Text("• English Grammar & Writing Master")
                    Text("• MHT-CET Exam Prep & MCQs")
                    Text("• Marathi Vyakaran & Nibandh")
                }
            },
            confirmButton = {
                TextButton(onClick = { showOtherAppsDialog = false }) {
                    Text("Close")
                }
            }
        )
    }

    if (showGuidelinesDialog) {
        AlertDialog(
            onDismissRequest = { showGuidelinesDialog = false },
            title = { Text("SSC Exam Guidelines") },
            text = {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text("1. Passing Criteria: Minimum 35% marks required in theory and internal assessment combined.")
                    Text("2. Answer Sheets: Neat diagrams in Geometry and Science carry dedicated marks.")
                    Text("3. Hall Ticket: Must be verified by school principal before exam dates.")
                }
            },
            confirmButton = {
                TextButton(onClick = { showGuidelinesDialog = false }) {
                    Text("Got It")
                }
            }
        )
    }

    if (showAboutDialog) {
        AlertDialog(
            onDismissRequest = { showAboutDialog = false },
            title = { Text("About Maharashtra SSC Hub") },
            text = { Text("Designed for Maharashtra State Board Std 10 (SSC) students. Providing curriculum resources, practice sets, and official past board papers to ensure academic excellence.") },
            confirmButton = {
                TextButton(onClick = { showAboutDialog = false }) {
                    Text("Close")
                }
            }
        )
    }
}

@Composable
fun AppDrawerContent(
    drawerState: DrawerState,
    currentRoute: String?,
    isDarkMode: Boolean,
    onNavigate: (String) -> Unit,
    onToggleDarkMode: () -> Unit,
    onShowGuidelines: () -> Unit,
    onShowRate: () -> Unit,
    onShowOtherApps: () -> Unit,
    onShowAbout: () -> Unit
) {
    ModalDrawerSheet(
        drawerState = drawerState,
        modifier = Modifier.width(300.dp),
        drawerContainerColor = MaterialTheme.colorScheme.surface
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.primary)
                .padding(24.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(56.dp)
                    .background(MaterialTheme.colorScheme.secondary, shape = androidx.compose.foundation.shape.CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.School,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(32.dp)
                )
            }
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "Maharashtra SSC Hub",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = "Std 10th Board Exam Preparation",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.tertiary
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        NavigationDrawerItem(
            icon = { Icon(Icons.Default.Home, contentDescription = null) },
            label = { Text("Home Dashboard") },
            selected = currentRoute == Screen.Home.route,
            onClick = { onNavigate(Screen.Home.route) }
        )

        NavigationDrawerItem(
            icon = { Icon(Icons.AutoMirrored.Filled.MenuBook, contentDescription = null) },
            label = { Text("Curriculum & Subjects") },
            selected = currentRoute == Screen.Subjects.route,
            onClick = { onNavigate(Screen.Subjects.route) }
        )

        NavigationDrawerItem(
            icon = { Icon(Icons.Default.Timer, contentDescription = null) },
            label = { Text("Pomodoro Study Timer") },
            selected = currentRoute == Screen.Pomodoro.route,
            onClick = { onNavigate(Screen.Pomodoro.route) }
        )

        NavigationDrawerItem(
            icon = { Icon(Icons.AutoMirrored.Filled.Assignment, contentDescription = null) },
            label = { Text("Past Board Papers") },
            selected = currentRoute == Screen.Papers.route,
            onClick = { onNavigate(Screen.Papers.route) }
        )

        NavigationDrawerItem(
            icon = { Icon(Icons.Default.CheckCircle, contentDescription = null) },
            label = { Text("Preparation Tracker") },
            selected = currentRoute == Screen.Progress.route,
            onClick = { onNavigate(Screen.Progress.route) }
        )

        HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))

        NavigationDrawerItem(
            icon = { Icon(if (isDarkMode) Icons.Default.DarkMode else Icons.Default.LightMode, contentDescription = null) },
            label = {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(if (isDarkMode) "Dark Mode" else "Normal Mode")
                    Switch(
                        checked = isDarkMode,
                        onCheckedChange = { onToggleDarkMode() }
                    )
                }
            },
            selected = false,
            onClick = { onToggleDarkMode() }
        )

        NavigationDrawerItem(
            icon = { Icon(Icons.Default.Info, contentDescription = null) },
            label = { Text("SSC Exam Guidelines") },
            selected = false,
            onClick = { onShowGuidelines() }
        )

        NavigationDrawerItem(
            icon = { Icon(Icons.Default.Star, contentDescription = null) },
            label = { Text("Rate Us") },
            selected = false,
            onClick = { onShowRate() }
        )

        NavigationDrawerItem(
            icon = { Icon(Icons.Default.Apps, contentDescription = null) },
            label = { Text("Other Apps") },
            selected = false,
            onClick = { onShowOtherApps() }
        )

        NavigationDrawerItem(
            icon = { Icon(Icons.Default.Info, contentDescription = null) },
            label = { Text("About") },
            selected = false,
            onClick = { onShowAbout() }
        )
    }
}
