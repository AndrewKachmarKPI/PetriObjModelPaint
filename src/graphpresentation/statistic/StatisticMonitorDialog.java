/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package graphpresentation.statistic;

import graphpresentation.PetriNetsFrame;
import graphpresentation.statistic.dto.configs.DataCollectionConfigDto;
import graphpresentation.statistic.services.ChartBuilderService;
import graphpresentation.statistic.services.LineChartBuilderService;
import graphpresentation.statistic.dto.configs.ChartConfigDto;
import graphpresentation.statistic.dto.data.PetriElementStatisticDto;
import graphpresentation.statistic.enums.PetriStatisticFunction;
import graphpresentation.statistic.services.FormulaBuilderService;
import graphpresentation.statistic.services.FormulaBuilderServiceImpl;
import graphpresentation.statistic.services.StatisticMonitorService;
import javafx.embed.swing.JFXPanel;
import javafx.scene.chart.XYChart;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * @author Andrii Kachmar
 */
public class StatisticMonitorDialog extends javax.swing.JDialog implements StatisticMonitorService {
    private final ChartBuilderService chartBuilderService;
    private final FormulaBuilderService formulaBuilderService;
    private Map<Integer, List<String>> elementsWatchMap;
    private Boolean isFormulaValid;
    private ChartConfigDto chartConfigDto;


    /**
     * Creates new form StatisticMonitorDialog
     */
    public StatisticMonitorDialog(PetriNetsFrame parent, boolean modal) {
        super(parent, modal);
        this.parent = parent;
        this.jfxPanel = new JFXPanel();
        this.formulaBuilderService = new FormulaBuilderServiceImpl(parent);
        initComponents();

        this.chartConfigDto = new ChartConfigDto(
                "Petri net statistics",
                "Simulation time",
                "Formula value",
                true
        );
        this.chartBuilderService = new LineChartBuilderService();
        chartBuilderService.createChart(jfxPanel, chartConfigDto);
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        contentLayout = new javax.swing.JSplitPane();
        formulaBarPanel = new javax.swing.JPanel();
        formulaActionsGroup = new javax.swing.JPanel();
        clearMonitorBtn = new javax.swing.JButton();
        formulaInfoBtn = new javax.swing.JButton();
        formulaPanel = new javax.swing.JScrollPane();
        formulaInputField = new javax.swing.JTextArea();
        mainContentPanel = new javax.swing.JPanel();
        chartViewPanel = new javax.swing.JPanel();
        chartActionsBar = new javax.swing.JMenuBar();
        chartToolsBar = new javax.swing.JPanel();
        tableViewPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Statistic monitor");
        setPreferredSize(new java.awt.Dimension(845, 600));

        contentLayout.setDividerLocation(50);
        contentLayout.setDividerSize(3);
        contentLayout.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        contentLayout.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        contentLayout.setMinimumSize(new java.awt.Dimension(80, 40));
        contentLayout.setPreferredSize(new java.awt.Dimension(845, 40));

        formulaBarPanel.setPreferredSize(new java.awt.Dimension(314, 70));
        formulaBarPanel.setLayout(new java.awt.BorderLayout());

        formulaActionsGroup.setLayout(new java.awt.GridBagLayout());

        clearMonitorBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utils/reset_icon.png")));
        clearMonitorBtn.setContentAreaFilled(false);
        clearMonitorBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clearMonitorBtn.setPreferredSize(new java.awt.Dimension(40, 40));
        clearMonitorBtn.setToolTipText("Clear chart");
        clearMonitorBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearFormulaBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        formulaActionsGroup.add(clearMonitorBtn, gridBagConstraints);

        formulaInfoBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utils/fx_icon.png")));
        formulaInfoBtn.setContentAreaFilled(false);
        formulaInfoBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        formulaInfoBtn.setPreferredSize(new java.awt.Dimension(40, 40));
        formulaInfoBtn.setToolTipText("Available formulas");
        formulaInfoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formulaInfoBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        formulaActionsGroup.add(formulaInfoBtn, gridBagConstraints);

        formulaBarPanel.add(formulaActionsGroup, java.awt.BorderLayout.LINE_START);

        formulaPanel.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        formulaPanel.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        formulaPanel.setPreferredSize(new java.awt.Dimension(234, 60));

        formulaInputField.setLineWrap(true);
        formulaInputField.setBorder(BorderFactory.createCompoundBorder(formulaInputField.getBorder(),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        formulaInputField.setFont(new Font("Consolas", Font.PLAIN, 14));
        formulaInputField.setToolTipText("Enter your formula...");
        formulaInputField.setPreferredSize(new java.awt.Dimension(232, 20));
        formulaInputField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                onFormulaFieldChange(e);
            }
        });
        formulaPanel.setViewportView(formulaInputField);
        formulaSuggestionPopup = new JPopupMenu();

        formulaBarPanel.add(formulaPanel, java.awt.BorderLayout.CENTER);

        contentLayout.setTopComponent(formulaBarPanel);

        mainContentPanel.setLayout(new javax.swing.BoxLayout(mainContentPanel, javax.swing.BoxLayout.LINE_AXIS));
        chartViewPanel.setLayout(new BorderLayout());
        chartViewPanel.setBackground(Color.decode("#f4f4f4"));

        dragChartBtn = new JToggleButton();
        dragChartBtn.setPreferredSize(new Dimension(100, 40));
        dragChartBtn.setHorizontalAlignment(SwingConstants.CENTER);
        dragChartBtn.setVerticalAlignment(SwingConstants.CENTER);
        dragChartBtn.setContentAreaFilled(false);
        dragChartBtn.setToolTipText("Drag chart content");
        dragChartBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dragChartBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utils/hand_icon.png")));
        dragChartBtn.addActionListener(e -> {
            if (dragChartBtn.isSelected()) {
                dragChartBtn.setContentAreaFilled(true);
                dragChartBtn.setBackground(Color.LIGHT_GRAY);
                dragChartBtn.transferFocus();
            } else {
                dragChartBtn.setContentAreaFilled(false);
            }
            chartConfigDto.toggleDragAndZoomEnabled();
            chartBuilderService.updateChartConfig(chartConfigDto);
        });

        scaleChartBtn = new JButton();
        scaleChartBtn.setPreferredSize(new Dimension(100, 40));
        scaleChartBtn.setHorizontalAlignment(SwingConstants.CENTER);
        scaleChartBtn.setVerticalAlignment(SwingConstants.CENTER);
        scaleChartBtn.setContentAreaFilled(false);
        scaleChartBtn.setToolTipText("Scale chart to original size");
        scaleChartBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        scaleChartBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utils/scale_icon.png")));
        scaleChartBtn.addActionListener(this::onScalePerformed);

        drawVerticalLineBtn = new JToggleButton();
        drawVerticalLineBtn.setPreferredSize(new Dimension(100, 40));
        drawVerticalLineBtn.setHorizontalAlignment(SwingConstants.CENTER);
        drawVerticalLineBtn.setVerticalAlignment(SwingConstants.CENTER);
        drawVerticalLineBtn.setContentAreaFilled(false);
        drawVerticalLineBtn.setToolTipText("Draw vertical line on chart");
        drawVerticalLineBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        drawVerticalLineBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utils/draw_vertical_icon.png")));
        drawVerticalLineBtn.addActionListener(e -> {
            if (drawVerticalLineBtn.isSelected()) {
                drawVerticalLineBtn.setContentAreaFilled(true);
                drawVerticalLineBtn.setBackground(Color.LIGHT_GRAY);
                drawVerticalLineBtn.transferFocus();
            } else {
                drawVerticalLineBtn.setContentAreaFilled(false);
            }
            chartConfigDto.toggleDrawVerticalLineEnabled();
            chartBuilderService.updateChartConfig(chartConfigDto);
        });

        drawHorizontalLineBtn = new JToggleButton();
        drawHorizontalLineBtn.setPreferredSize(new Dimension(100, 40));
        drawHorizontalLineBtn.setHorizontalAlignment(SwingConstants.CENTER);
        drawHorizontalLineBtn.setVerticalAlignment(SwingConstants.CENTER);
        drawHorizontalLineBtn.setContentAreaFilled(false);
        drawHorizontalLineBtn.setToolTipText("Draw horizontal line on chart");
        drawHorizontalLineBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        drawHorizontalLineBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utils/draw_horizontal_icon.png")));
        drawHorizontalLineBtn.addActionListener(e -> {
            if (drawHorizontalLineBtn.isSelected()) {
                drawHorizontalLineBtn.setContentAreaFilled(true);
                drawHorizontalLineBtn.setBackground(Color.LIGHT_GRAY);
                drawHorizontalLineBtn.transferFocus();
            } else {
                drawHorizontalLineBtn.setContentAreaFilled(false);
            }
            chartConfigDto.toggleDrawHorizontalLineEnabled();
            chartBuilderService.updateChartConfig(chartConfigDto);
        });

        clearDrawLineBtn = new JToggleButton();
        clearDrawLineBtn.setPreferredSize(new Dimension(100, 40));
        clearDrawLineBtn.setHorizontalAlignment(SwingConstants.CENTER);
        clearDrawLineBtn.setVerticalAlignment(SwingConstants.CENTER);
        clearDrawLineBtn.setContentAreaFilled(false);
        clearDrawLineBtn.setToolTipText("Clear chart drawings");
        clearDrawLineBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clearDrawLineBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utils/eraser_icon.png")));
        clearDrawLineBtn.addActionListener(e -> {
            if (clearDrawLineBtn.isSelected()) {
                clearDrawLineBtn.setContentAreaFilled(true);
                clearDrawLineBtn.setBackground(Color.LIGHT_GRAY);
                clearDrawLineBtn.transferFocus();
            } else {
                clearDrawLineBtn.setContentAreaFilled(false);
            }
            chartConfigDto.toggleClearLineEnabled();
            chartBuilderService.updateChartConfig(chartConfigDto);
        });

        createLabelBtn = new JToggleButton();
        createLabelBtn.setPreferredSize(new Dimension(100, 40));
        createLabelBtn.setHorizontalAlignment(SwingConstants.CENTER);
        createLabelBtn.setVerticalAlignment(SwingConstants.CENTER);
        createLabelBtn.setContentAreaFilled(false);
        createLabelBtn.setToolTipText("Create text label on chart");
        createLabelBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        createLabelBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utils/text_icon.png")));
        createLabelBtn.addActionListener(e -> {
            if (createLabelBtn.isSelected()) {
                createLabelBtn.setContentAreaFilled(true);
                createLabelBtn.setBackground(Color.LIGHT_GRAY);
                createLabelBtn.transferFocus();
            } else {
                createLabelBtn.setContentAreaFilled(false);
            }
            chartConfigDto.toggleCreateLabelEnabled();
            chartBuilderService.updateChartConfig(chartConfigDto);
        });

        chartDownloadBtn = new JButton();
        chartDownloadBtn.setPreferredSize(new Dimension(100, 40));
        chartDownloadBtn.setHorizontalAlignment(SwingConstants.CENTER);
        chartDownloadBtn.setVerticalAlignment(SwingConstants.CENTER);
        chartDownloadBtn.setContentAreaFilled(false);
        chartDownloadBtn.setToolTipText("Download chart as image");
        chartDownloadBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        chartDownloadBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utils/download_icon.png")));
        chartDownloadBtn.addActionListener(this::onChartDownloadPerformed);

        exportCsvBtn = new JButton();
        exportCsvBtn.setPreferredSize(new Dimension(100, 40));
        exportCsvBtn.setHorizontalAlignment(SwingConstants.CENTER);
        exportCsvBtn.setVerticalAlignment(SwingConstants.CENTER);
        exportCsvBtn.setContentAreaFilled(false);
        exportCsvBtn.setToolTipText("Export statistic in csv");
        exportCsvBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exportCsvBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utils/export_csv_icon.png")));
        exportCsvBtn.addActionListener(this::onExportCsvPerformed);

        chartSettingsBtn = new JButton();
        chartSettingsBtn.setPreferredSize(new Dimension(100, 40));
        chartSettingsBtn.setHorizontalAlignment(SwingConstants.CENTER);
        chartSettingsBtn.setVerticalAlignment(SwingConstants.CENTER);
        chartSettingsBtn.setContentAreaFilled(false);
        chartSettingsBtn.setToolTipText("Chart settings");
        chartSettingsBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        chartSettingsBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utils/settings_icon.png")));
        chartSettingsBtn.addActionListener(this::onChartSettingOpenPerformed);

        chartToolsBar.setBackground(Color.decode("#f4f4f4"));
        chartToolsBar.setLayout(new BoxLayout(chartToolsBar, BoxLayout.Y_AXIS));
        chartToolsBar.add(Box.createVerticalStrut(10));
        chartToolsBar.setPreferredSize(new Dimension(40, 100));
        chartToolsBar.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(0, 1, 0, 0, Color.LIGHT_GRAY),
                chartToolsBar.getBorder()
        ));

        chartToolsBar.add(dragChartBtn);
        chartToolsBar.add(scaleChartBtn);
        chartToolsBar.add(drawVerticalLineBtn);
        chartToolsBar.add(drawHorizontalLineBtn);
        chartToolsBar.add(createLabelBtn);
        chartToolsBar.add(clearDrawLineBtn);
        chartToolsBar.add(getHorizontalSeparator());
        chartToolsBar.add(chartDownloadBtn);
        chartToolsBar.add(exportCsvBtn);
        chartToolsBar.add(chartSettingsBtn);


        chartViewPanel.add(chartToolsBar, BorderLayout.EAST);
        chartViewPanel.add(chartActionsBar, BorderLayout.NORTH);
        chartViewPanel.add(jfxPanel, BorderLayout.CENTER);

        javax.swing.GroupLayout tableViewPanelLayout = new javax.swing.GroupLayout(tableViewPanel);
        tableViewPanel.setLayout(tableViewPanelLayout);
        tableViewPanelLayout.setHorizontalGroup(
                tableViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 845, Short.MAX_VALUE)
        );
        tableViewPanelLayout.setVerticalGroup(
                tableViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 470, Short.MAX_VALUE)
        );

        mainContentPanel.add(chartViewPanel);

        contentLayout.setRightComponent(mainContentPanel);

        getContentPane().add(contentLayout, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private static JSeparator getHorizontalSeparator() {
        JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
        separator.setPreferredSize(new Dimension(100, 5));
        return separator;
    }

    private void formulaInfoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_formulaInfoBtnActionPerformed
        SelectFunctionDialog selectFunctionDialog = new SelectFunctionDialog(this.parent, true);
        selectFunctionDialog.setLocationRelativeTo(this);
        selectFunctionDialog.setVisible(true);
        PetriStatisticFunction selectedFunction = selectFunctionDialog.getSelectedFunction();
        if (selectedFunction != null) {
            String formula = formulaBuilderService.updateFormula(formulaInputField.getText(), selectedFunction.getFunctionName());
            formulaInputField.setText(formula);
            onFormulaFieldChange(null);
        }
    }//GEN-LAST:event_formulaInfoBtnActionPerformed

    private void clearFormulaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearFormulaBtnActionPerformed
        chartBuilderService.clearChart();
        chartBuilderService.clearDrawings();
    }//GEN-LAST:event_clearFormulaBtnActionPerformed

    private void onChartSettingOpenPerformed(java.awt.event.ActionEvent evt) {
        ChartSettingsDialog chartSettingsDialog = new ChartSettingsDialog(parent, true, chartConfigDto, chartBuilderService);
        chartSettingsDialog.setLocationRelativeTo(this);
        chartSettingsDialog.setVisible(true);
        ChartConfigDto configDto = chartSettingsDialog.getChartConfigDto();
        if (configDto != null) {
            chartConfigDto = configDto;
        }
    }

    private void onChartDownloadPerformed(java.awt.event.ActionEvent evt) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int option = fileChooser.showOpenDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            chartBuilderService.exportChartAsImage(file.getAbsolutePath());
        }
    }

    private void onExportCsvPerformed(java.awt.event.ActionEvent evt) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int option = fileChooser.showOpenDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            String fileName = file.getAbsolutePath();
            chartBuilderService.exportChartAsTable(fileName);
        }
    }

    private void onScalePerformed(java.awt.event.ActionEvent evt) {
        chartBuilderService.autoSizeChart();
    }

    private void onFormulaFieldChange(KeyEvent e) {
        String formula = formulaInputField.getText().trim();
        if (formula.isEmpty()) {
            return;
        }
        this.isFormulaValid = formulaBuilderService.isFormulaValid(formula);

        List<String> suggestions = formulaBuilderService.getFormulaSuggestions(formula);
        updateFormulaSuggestions(suggestions);
        updateFormulaField();
    }

    private void updateFormulaSuggestions(List<String> suggestions) {
        formulaSuggestionPopup.setVisible(false);
        if (!suggestions.isEmpty()) {
            formulaSuggestionPopup.removeAll();
            for (String suggestion : suggestions) {
                JMenuItem item = new JMenuItem(suggestion);
                item.addActionListener(e -> {
                    String formula = formulaBuilderService.updateFormula(formulaInputField.getText(), suggestion);
                    formulaInputField.setText(formula);
                    formulaSuggestionPopup.setVisible(false);
                    onFormulaFieldChange(null);
                });
                formulaSuggestionPopup.add(item);
            }
            Point position = formulaInputField.getCaret().getMagicCaretPosition();
            if (position != null) {
                formulaSuggestionPopup.show(formulaInputField, position.x, position.y + formulaInputField.getFontMetrics(formulaInputField.getFont()).getHeight());
            } else {
                formulaSuggestionPopup.show(formulaInputField, 0, formulaInputField.getHeight());
            }
            formulaInputField.requestFocus();
        }
    }

    private void updateFormulaField() {
        formulaInputField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(isFormulaValid ? Color.GREEN : Color.RED, 2),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
    }

    public void onSimulationStart() {
        elementsWatchMap = formulaBuilderService.getFormulaElementsWatchMap(formulaInputField.getText());
        formulaInputField.setEnabled(false);
        formulaInfoBtn.setEnabled(false);
        clearMonitorBtn.setEnabled(false);
        dragChartBtn.setEnabled(false);
        drawVerticalLineBtn.setEnabled(false);
        drawHorizontalLineBtn.setEnabled(false);
        createLabelBtn.setEnabled(false);
        clearMonitorBtn.setEnabled(false);
        scaleChartBtn.setEnabled(false);
        chartDownloadBtn.setEnabled(false);
        chartSettingsBtn.setEnabled(false);
        exportCsvBtn.setEnabled(false);
        clearDrawLineBtn.setEnabled(false);
        if (isFormulaValid) {
            chartBuilderService.createSeries(formulaInputField.getText());
        }
    }

    public void onSimulationEnd() {
        formulaInputField.setEnabled(true);
        formulaInfoBtn.setEnabled(true);
        clearMonitorBtn.setEnabled(true);
        dragChartBtn.setEnabled(true);
        drawVerticalLineBtn.setEnabled(true);
        drawHorizontalLineBtn.setEnabled(true);
        createLabelBtn.setEnabled(true);
        clearMonitorBtn.setEnabled(true);
        scaleChartBtn.setEnabled(true);
        chartDownloadBtn.setEnabled(true);
        chartSettingsBtn.setEnabled(true);
        exportCsvBtn.setEnabled(true);
        clearDrawLineBtn.setEnabled(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Frame parent;
    private javax.swing.JPanel chartViewPanel;
    private javax.swing.JMenuBar chartActionsBar;
    private javax.swing.JButton clearMonitorBtn;
    private javax.swing.JButton chartSettingsBtn;
    private javax.swing.JButton chartDownloadBtn;
    private javax.swing.JButton exportCsvBtn;
    private javax.swing.JButton scaleChartBtn;
    private javax.swing.JToggleButton createLabelBtn;
    private javax.swing.JPanel chartToolsBar;
    private javax.swing.JToggleButton dragChartBtn;
    private javax.swing.JToggleButton drawVerticalLineBtn;
    private javax.swing.JToggleButton drawHorizontalLineBtn;
    private javax.swing.JToggleButton clearDrawLineBtn;
    private javax.swing.JSplitPane contentLayout;
    private javax.swing.JPanel formulaActionsGroup;
    private javax.swing.JPanel formulaBarPanel;
    private javax.swing.JButton formulaInfoBtn;
    private javax.swing.JTextArea formulaInputField;
    private javax.swing.JScrollPane formulaPanel;
    private javax.swing.JPanel mainContentPanel;
    private javax.swing.JPanel tableViewPanel;
    private javax.swing.JPopupMenu formulaSuggestionPopup;
    private final JFXPanel jfxPanel;
    // End of variables declaration//GEN-END:variables

    @Override
    public Map<Integer, List<String>> getElementsWatchMap() {
        return elementsWatchMap;
    }

    @Override
    public boolean getIsFormulaValid() {
        return isFormulaValid;
    }

    @Override
    public void appendChartStatistic(double currentTime, List<PetriElementStatisticDto> statistics) {
        if (!isFormulaValid) {
            return;
        }
        Number formulaValue = formulaBuilderService.calculateFormula(formulaInputField.getText(), statistics);
        if (formulaValue != null) {
            chartBuilderService.appendData(new XYChart.Data<>(currentTime, formulaValue));
        }
    }

    @Override
    public DataCollectionConfigDto getChartDataCollectionConfig() {
        DataCollectionConfigDto configDto = chartConfigDto.getDataCollectionConfig();
        return configDto != null ? configDto : new DataCollectionConfigDto();
    }
}
